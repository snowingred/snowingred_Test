package RabbitMq.RPC;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeoutException;

public class RPCSend {
    private static String QUEUE_NAME ="rpc";
    private Connection con;
    private Channel ch;

    public RPCSend() throws Exception {
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.64.140");
        f.setUsername("admin");
        f.setPassword("admin");
        con = f.newConnection();
        ch = con.createChannel();
    }

    public String call(String n) throws IOException, TimeoutException, InterruptedException {
//       设置回调队列的uid
        String uid = UUID.randomUUID().toString();
//        设置回调队列名称
        String RpcQueue = ch.queueDeclare().getQueue();
//        //设置两个参数:
//		//1. 请求和响应的关联id
//		//2. 传递响应数据的queue
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties.Builder()
                .correlationId(uid).replyTo(RpcQueue).build();
        ch.basicPublish("",QUEUE_NAME,basicProperties,n.getBytes());
//      设置阻塞队列获取回调的数据
        ArrayBlockingQueue response = new ArrayBlockingQueue<String>(1);

        //接收响应数据的回调对象
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                //如果响应消息的关联id,与请求的关联id相同,我们来处理这个响应数据
                if (message.getProperties().getCorrelationId().contentEquals(uid)) {
                    //把收到的响应数据,放入阻塞集合
                    response.offer(new String(message.getBody(), "UTF-8"));
                }
            }
        };

        ch.basicConsume(RpcQueue, true, deliverCallback, cancelCallback -> {
        });
        String fbnq = (String) response.take();
        return fbnq;
    }

    public static void main(String[] args) throws Exception {
        RPCSend rpcSend = new RPCSend();
        String call = rpcSend.call("5");
        System.out.println(call);


    }

}
