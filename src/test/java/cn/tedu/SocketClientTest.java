package cn.tedu;

import java.io.*;
import java.net.Socket;

public class SocketClientTest {

    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 9999);
        //从键盘写入
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        while(true){
            String re = b.readLine();
            //输出流
            dos.writeUTF(re);
            dos.flush();

            //输入流
            String a = dis.readUTF();
            System.out.println(a);
            if (a.equals("服务器--》：1")){
                dis.close();
                System.out.println(dis);
                String s = dis.readUTF();
                System.out.println(s);
            }

        }
    }
}
