package RabbitMq.RPC;

import com.rabbitmq.client.*;

import java.io.IOException;

public class RPCReve {
    private static String QUEUE_NAME ="RPC";
    private Connection con;
    private Channel ch;

    static long fbnq(int n) {
        if (n==1||n==2) {
            return 1;
        }
        return fbnq(n-1)+fbnq(n-2);

    }

    public RPCReve() throws Exception {
        ConnectionFactory f = new ConnectionFactory();
        f.setHost("192.168.64.140");
        f.setUsername("admin");
        f.setPassword("admin");
        con = f.newConnection();
        ch = con.createChannel();
    }

    public static void main(String[] args) throws Exception {
        RPCReve rpcReve = new RPCReve();
        Channel ch = rpcReve.ch;
        ch.queueDeclare("rpc", false, false, false, null);
        DeliverCallback deliverCallback = new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) throws IOException {
                // TODO Auto-generated method stub
                String A
                        = new String(message.getBody());
                int a = Integer.parseInt(A);
                long fbnq = fbnq(a);
                String correlationId = message.getProperties().getCorrelationId();
                String replyTo = message.getProperties().getReplyTo();
                BasicProperties props=new AMQP.BasicProperties.Builder().correlationId(correlationId).build();
                ch.basicPublish("", replyTo, (AMQP.BasicProperties) props, (""+fbnq).getBytes());
            }

        };
        CancelCallback cancelCallback = new CancelCallback() {

            @Override
            public void handle(String consumerTag) throws IOException {
                // TODO Auto-generated method stub

            }
        };
        ch.basicConsume("rpc", true, deliverCallback, cancelCallback);
    }
    }

