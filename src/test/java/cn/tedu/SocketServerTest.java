package cn.tedu;//在初步了解了Socket的基础知识，了解了Socket的传输之后，简单写一个手机用Socket进行聊天功能的Demo

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//1.先写一个server和client进行交互的例子
public class SocketServerTest {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        //设置超时时间，过了时间会自动关闭
        server.setSoTimeout(60000*10);
        Socket client = server.accept();
        while(true){
            //输入流
            DataInputStream dis = new DataInputStream(client.getInputStream());
            String a = dis.readUTF();
            //输出流
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF("服务器--》："+a);
            dos.flush();
        }
    }
}

