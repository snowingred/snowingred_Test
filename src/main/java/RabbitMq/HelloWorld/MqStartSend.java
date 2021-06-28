package RabbitMq.HelloWorld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MqStartSend {
    private static String QUEUE_NAME ="hello";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.64.140");
        connectionFactory.setPassword("admin");
        connectionFactory.setUsername("admin");
//      资源在使用结束后自动释放 try(资源)
        try (Connection connection = connectionFactory.newConnection();
             Channel channel = connection.createChannel();
        ){
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String msg= "hello mis zhou" ;
            String msg1= "hello mis zhou1" ;
            String msg2= "hello mis zhou2" ;
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            channel.basicPublish("",QUEUE_NAME,null,msg1.getBytes());
            channel.basicPublish("",QUEUE_NAME,null,msg2.getBytes());
            System.out.println("消息发送."+msg+"，");
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
