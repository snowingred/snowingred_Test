package RabbitMq.HelloWorld;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MqStartRecevice {
    private final static String QUEUE_NAME="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.64.140");
        factory.setPassword("admin");
        factory.setUsername("admin");
         Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

     /*   channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        DeliverCallback deliverCallback=(consumerTag,delivery)->{
            String message= new String(delivery.getBody(),"UTF-8");
            System.out.println("RECEIVED"+message);
        };
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,consumerTag->{});*/
        GetResponse getResponse = channel.basicGet(QUEUE_NAME, true);
        System.out.println("接收到消息"+ new String(getResponse.getBody(),"UTF-8"));
    }
}
