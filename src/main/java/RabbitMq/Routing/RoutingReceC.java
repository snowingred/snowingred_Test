package RabbitMq.Routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RoutingReceC {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.140");
        connectionFactory.setPassword("admin");
        connectionFactory.setUsername("admin");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue,"MQ-direct","c");
        DeliverCallback deliverCallback=(consumerTag, delivery)->{
            String s = new String(delivery.getBody(), "UTF-8");
            System.out.println(s);
        };
        channel.basicConsume(queue,true,deliverCallback,delivery->{});


    }
}
