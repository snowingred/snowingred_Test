package RabbitMq.WorkQueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class WorkQueueReve {
    private static String QUEUE_NAME ="workQueue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.140");
        connectionFactory.setPassword("admin");
        connectionFactory.setUsername("admin");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        DeliverCallback deliverCallback=(consumerTag, delivery)->{
            String msgess = new String(delivery.getBody(), "UTF-8");
            System.out.println(msgess);
        };
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,delivery->{});

    }
}
