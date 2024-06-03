import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Technician {
    private static final String REQUEST_EXCHANGE = "request-exchange";
    private static final String RESPONSE_EXCHANGE = "response-exchange";
    private static final String BROADCAST_EXCHANGE = "broadcast-exchange";
    private static final String ADMIN_EXCHANGE = "admin-exchange";
    private static String technicianId;
    private static final List<String> supportedExams = new ArrayList<>();

    public static void main(String[] args) throws IOException, TimeoutException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter technician ID: ");
        technicianId = scanner.nextLine();

        System.out.print("Enter supported exam types (comma separated, e.g., knee,hip,elbow): ");
        String[] exams = scanner.nextLine().split(",");
        for (String exam : exams) {
            supportedExams.add(exam.trim());
        }

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(REQUEST_EXCHANGE, "direct");
        channel.exchangeDeclare(RESPONSE_EXCHANGE, "direct");
        channel.exchangeDeclare(BROADCAST_EXCHANGE, "fanout");
        channel.exchangeDeclare(ADMIN_EXCHANGE, "fanout");

        Consumer broadcastConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("[TECHNICIAN " + technicianId + " BROADCAST] " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        String broadcastQueue = technicianId + "-broadcast-queue";
        channel.queueDeclare(broadcastQueue, false, false, false, null);
        channel.queueBind(broadcastQueue, BROADCAST_EXCHANGE, "");
        channel.basicConsume(broadcastQueue, false, broadcastConsumer);

        for (String exam : supportedExams) {
            String queueName = exam + "-queue";
            channel.queueDeclare(queueName, false, false, false, null);
            channel.queueBind(queueName, REQUEST_EXCHANGE, exam);
            channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, StandardCharsets.UTF_8);
                    String[] content = message.split("\\|");
                    String doctorId = content[1];
                    String patientId = content[2];
                    String examType = content[3];

                    System.out.println("[TECHNICIAN: " + technicianId + " INFO] Examining patient: " + patientId + " sent by " + doctorId + " with issues with: " + examType);

                    String response = patientId + " " + examType + " done";
                    channel.basicPublish(RESPONSE_EXCHANGE, doctorId, null, response.getBytes(StandardCharsets.UTF_8));

                    channel.basicPublish(ADMIN_EXCHANGE, "", null, response.getBytes(StandardCharsets.UTF_8));
                }
            });
        }

        System.out.println("Technician " + technicianId + " waiting for messages...");
    }
}
