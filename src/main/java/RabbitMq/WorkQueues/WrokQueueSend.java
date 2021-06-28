package RabbitMq.WorkQueues;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class WrokQueueSend {
    private static String QUEUE_NAME ="workQueue";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.140");
        connectionFactory.setPassword("admin");
        connectionFactory.setUsername("admin");
        String msg=".....";
        String msg1="..";
        String msg2="....";
        String msg3="...";
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        channel.basicPublish("",QUEUE_NAME,null,msg1.getBytes());
        channel.basicPublish("",QUEUE_NAME,null,msg2.getBytes());
        channel.basicPublish("",QUEUE_NAME,null,msg3.getBytes());
        System.out.println("服务器发送消息"+msg);
        System.out.println("服务器发送消息"+msg1);
        System.out.println("服务器发送消息"+msg2);
        System.out.println("服务器发送消息"+msg3);

    }

}
