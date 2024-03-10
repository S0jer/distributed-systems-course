package chat;

import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 12345;
    private static final String MULTICAST_ADDRESS = "224.0.0.1";
    private static final int MULTICAST_PORT = 8888;
    private static final int RECONNECT_COUNT_DEFAULT = 20;
    private static int reconnectCount = RECONNECT_COUNT_DEFAULT;
    private static volatile boolean isConnected = false;
    private static String clientId = null;
    private static MulticastSocket multicastSocket = null;
    private static final BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) {
        initializeConnection();
    }

    private static void initializeConnection() {
        while (reconnectCount >= 0 && !isConnected) {
            if (multicastSocket != null && !multicastSocket.isClosed()) {
                multicastSocket.close();
            }
            try (
                    Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    DatagramSocket udpSocket = new DatagramSocket()
            ) {
                isConnected = true;
                System.out.println("Connected to the server.");

                multicastSocket = new MulticastSocket(MULTICAST_PORT);
                NetworkInterface networkInterface = NetworkInterface.getByInetAddress(InetAddress.getByName(MULTICAST_ADDRESS));
                InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);
                InetAddress multicastAddress = InetAddress.getByName(MULTICAST_ADDRESS);
                multicastSocket.joinGroup(new InetSocketAddress(multicastAddress, MULTICAST_PORT), networkInterface);

                if (clientId == null) {
                    System.out.print("Enter your ID/Nick: ");
                    clientId = stdIn.readLine();
                }
                out.println(clientId);

                handleThreads(in, multicastSocket);
                handleClientModes(serverAddress, udpSocket, clientId, multicastAddress, multicastSocket, out);

                multicastSocket.leaveGroup(new InetSocketAddress(multicastAddress, MULTICAST_PORT), networkInterface);
            } catch (IOException e) {
                isConnected = false;
                System.err.println("Could not connect to the server. Attempting to reconnect...");
                attemptReconnection();
            }
        }
    }

    private static void handleClientModes(InetAddress serverAddress, DatagramSocket udpSocket, String clientId, InetAddress multicastAddress, MulticastSocket multicastSocket, PrintWriter out) throws IOException {
        boolean useUdp = false;
        boolean useMulticast = false;
        String userInput;
        while ((userInput = stdIn.readLine()) != null && isConnected) {
            if (userInput.equalsIgnoreCase("U")) {
                useUdp = true;
                useMulticast = false;
                System.out.println("UDP mode ON. Type your message:");
            } else if (userInput.equalsIgnoreCase("M")) {
                useUdp = false;
                useMulticast = true;
                System.out.println("Multicast mode ON. Type your message:");
            } else {
                if (useUdp) {
                    handleUdpConnection(userInput, serverAddress, udpSocket);
                    useUdp = false;
                } else if (useMulticast) {
                    handleMulticastConnection(clientId, userInput, multicastAddress, multicastSocket);
                    useMulticast = false;
                } else {
                    out.println(userInput);
                }
            }
        }
    }

    private static void handleThreads(BufferedReader in, MulticastSocket multicastSocket) {
        new Thread(() -> {
            try {
                String serverMessage;
                while ((serverMessage = in.readLine()) != null && isConnected) {
                    System.out.println(serverMessage);
                }
            } catch (IOException e) {
                System.err.println("Connection to server lost.");
            } finally {
                isConnected = false;
            }
        }).start();

        new Thread(() -> {
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            while (isConnected) {
                try {
                    multicastSocket.receive(packet);
                    String received = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Multicast " + received);
                } catch (IOException e) {
                    if (!isConnected) {
                        break;
                    }
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void handleMulticastConnection(String clientId, String userInput, InetAddress multicastAddress, MulticastSocket multicastSocket) throws IOException {
        byte[] buf = (clientId + ": " + userInput).getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, multicastAddress, MULTICAST_PORT);
        multicastSocket.send(packet);
    }

    private static void handleUdpConnection(String userInput, InetAddress serverAddress, DatagramSocket udpSocket) throws IOException {
        byte[] buf = userInput.getBytes();
//                            byte[] buf = (".--.\n" +
//                                                        "|__| .-------.\n" +
//                                                        "|=.| |.-----.|\n" +
//                                                        "|--| || KCK ||\n" +
//                                                        "|  | |'-----'|\n" +
//                                                        "|__|~')_____('".getBytes()).getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, serverAddress, SERVER_PORT);
        udpSocket.send(packet);
    }

    private static void attemptReconnection() {
        if (reconnectCount-- <= 0) return;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        initializeConnection();
    }
}
