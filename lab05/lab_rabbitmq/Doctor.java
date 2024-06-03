import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Doctor {
    private static final String REQUEST_EXCHANGE = "request-exchange";
    private static final String RESPONSE_EXCHANGE = "response-exchange";
    private static final String BROADCAST_EXCHANGE = "broadcast-exchange";
    private static final String ADMIN_EXCHANGE = "admin-exchange";
    private static String doctorId;
    private static String responseQueue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter doctor ID: ");
        doctorId = scanner.nextLine();
        responseQueue = doctorId + "-queue";

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(REQUEST_EXCHANGE, "direct");
            channel.exchangeDeclare(RESPONSE_EXCHANGE, "direct");
            channel.exchangeDeclare(BROADCAST_EXCHANGE, "fanout");
            channel.exchangeDeclare(ADMIN_EXCHANGE, "fanout");

            Thread senderThread = new Thread(() -> {
                try {
                    sendRequest(channel);
                } catch (IOException | TimeoutException e) {
                    e.printStackTrace();
                }
            });
            senderThread.start();

            receiveResponseAndBroadcast(channel);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void sendRequest(Channel channel) throws IOException, TimeoutException {
        Scanner scanner = new Scanner(System.in);
        boolean doctorWork = true;
        while (doctorWork) {
            System.out.println("Enter patient id: ");
            String patientId = scanner.nextLine();

            String examType;
            while (true) {
                System.out.println("Enter examination type (knee|hip|elbow): ");
                examType = scanner.nextLine();
                if (!examType.equals("knee") && !examType.equals("hip") && !examType.equals("elbow")) {
                    System.out.println("[DOCTOR ERROR] Invalid examination type, try again!");
                    continue;
                }
                break;
            }
            String message = String.format("[DOCTOR: %s REQUEST]|%s|%s|%s", doctorId, doctorId, patientId, examType);
            channel.basicPublish(REQUEST_EXCHANGE, examType, null, message.getBytes(StandardCharsets.UTF_8));
            channel.basicPublish(ADMIN_EXCHANGE, examType, null, message.getBytes(StandardCharsets.UTF_8));
        }
    }

    private static void receiveResponseAndBroadcast(Channel channel) throws IOException, TimeoutException {
        channel.queueDeclare(responseQueue, false, false, false, null);
        channel.queueBind(responseQueue, RESPONSE_EXCHANGE, doctorId);

        String broadcastQueue = doctorId + "-broadcast-queue";
        channel.queueDeclare(broadcastQueue, false, false, false, null);
        channel.queueBind(broadcastQueue, BROADCAST_EXCHANGE, "");

        Consumer responseConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("[DOCTOR: " + doctorId + " INFO] " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(responseQueue, false, responseConsumer);

        Consumer broadcastConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("[DOCTOR: " + doctorId + " BROADCAST] " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(broadcastQueue, false, broadcastConsumer);
    }
}
