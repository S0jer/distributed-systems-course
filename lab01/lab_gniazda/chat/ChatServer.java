package chat;


import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final ConcurrentHashMap<String, PrintWriter> clients = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(PORT);
                DatagramSocket udpSocket = new DatagramSocket(PORT)
        ) {
            System.out.println("Chat server is running...");
            executor.execute(new UdpServerThread(udpSocket));

            while (true) {
                Socket clientTcpSocket = serverSocket.accept();
                executor.execute(new TcpServerThread(clientTcpSocket));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static class TcpServerThread implements Runnable {
        private final Socket tcpSocket;
        private String clientId;

        public TcpServerThread(Socket tcpSocket) {
            this.tcpSocket = tcpSocket;
        }

        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream(), StandardCharsets.UTF_8));
                    PrintWriter out = new PrintWriter(tcpSocket.getOutputStream(), true, StandardCharsets.UTF_8)
            ) {
                while (true) {
                    clientId = in.readLine();
                    synchronized (clients) {
                        if (clients.containsKey(clientId)) {
                            out.println("ClientIdTaken");
                        } else {
                            clients.put(clientId, out);
                            out.println("ClientIdAccepted");
                            break;
                        }
                    }
                }

                String message;
                while ((message = in.readLine()) != null) {
                    for (String receiverId : clients.keySet()) {
                        if (!Objects.equals(receiverId, clientId)) {
                            PrintWriter writer = clients.get(receiverId);
                            writer.println(clientId + ": " + message);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + clientId);
            } finally {
                if (clientId != null) {
                    clients.remove(clientId);
                }
                try {
                    tcpSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket for client: " + clientId);
                }
            }
        }
    }


    private static class UdpServerThread implements Runnable {
        private final DatagramSocket udpSocket;
        private final boolean running;

        public UdpServerThread(DatagramSocket udpSocket) {
            this.udpSocket = udpSocket;
            this.running = true;
        }

        public void run() {
            byte[] receiveBuffer = new byte[1024];

            while (running) {
                try {
                    DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                    udpSocket.receive(receivePacket);

                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength(), StandardCharsets.UTF_8);
                    int delimiterIndex = message.indexOf(":");
                    if (delimiterIndex == -1) continue;

                    String clientId = message.substring(0, delimiterIndex);

                    for (String receiverId : clients.keySet()) {
                        if (!Objects.equals(receiverId, clientId)) {
                            PrintWriter writer = clients.get(receiverId);
                            writer.println("UDP " + message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            udpSocket.close();
        }
    }
}


