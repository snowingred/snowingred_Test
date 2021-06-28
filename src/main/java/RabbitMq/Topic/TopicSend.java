package RabbitMq.Topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TopicSend {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.140");
        connectionFactory.setPassword("admin");
        connectionFactory.setUsername("admin");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("MQ-topic","topic");
        String msg= "hello mis zhou" ;
        String msg1= "hello mis zhou1" ;
        String msg2= "hello mis zhou2" ;
        channel.basicPublish("MQ-topic","kern.critical",null,msg.getBytes());
        channel.basicPublish("MQ-topic","abc.edf",null,msg1.getBytes());
        channel.basicPublish("MQ-topic","abc.ggg",null,msg2.getBytes());
    }

}
