package lab_tasks;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class JavaUdpServer {

    public static void main(String args[]) {
        System.out.println("JAVA UDP SERVER");
        DatagramSocket socket = null;
        int portNumber = 9008;

        try {
            socket = new DatagramSocket(portNumber);
            byte[] receiveBuffer = new byte[1024];
//            byte[] receiveBuffer = new byte[4];

            while (true) {
                Arrays.fill(receiveBuffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                String msg = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
                System.out.println("received msg: " + msg);
                if (msg.contains("Java")) {
                    System.out.println("From Java client");
                } else {
                    System.out.println("From Python client");
                }

                String response = "Pong from Server";
                byte[] sendResponse = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendResponse, sendResponse.length, receivePacket.getAddress(), receivePacket.getPort());
                socket.send(sendPacket);


//                ByteBuffer wrapped = ByteBuffer.wrap(receivePacket.getData()).order(ByteOrder.LITTLE_ENDIAN);
//                int receivedNumber = wrapped.getInt();
//                System.out.println("Received number: " + receivedNumber);
//
//                int incrementedNumber = receivedNumber + 1;
//                ByteBuffer buffer = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
//                buffer.putInt(incrementedNumber);
//                byte[] sendBuffer = buffer.array();
//                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
//                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
