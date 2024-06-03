import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Admin {
    private static final String BROADCAST_EXCHANGE = "broadcast-exchange";
    private static final String ADMIN_EXCHANGE = "admin-exchange";
    private static final String ADMIN_QUEUE = "admin-queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(BROADCAST_EXCHANGE, "fanout");
        channel.exchangeDeclare(ADMIN_EXCHANGE, "fanout");

        channel.queueDeclare(ADMIN_QUEUE, false, false, false, null);
        channel.queueBind(ADMIN_QUEUE, ADMIN_EXCHANGE, "");

        Consumer adminConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("[ADMIN] Received: " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(ADMIN_QUEUE, false, adminConsumer);

        Thread broadcastThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.println("Enter broadcast message (admin will not receive it): ");
                    String message = scanner.nextLine();
                    channel.basicPublish(BROADCAST_EXCHANGE, "", null, message.getBytes(StandardCharsets.UTF_8));
                    System.out.println("[ADMIN] Broadcast message: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        broadcastThread.start();
    }
}
