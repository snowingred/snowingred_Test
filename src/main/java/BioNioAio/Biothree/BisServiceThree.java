package BioNioAio.Biothree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务器启动多线程处理多个客户端
 */
public class BisServiceThree {
    public static void main(String[] args) {

        try {
            System.out.println("服务器启动");
            ServerSocket serverSocket = new ServerSocket( 9999);
            while (true){
            Socket accept = serverSocket.accept();
            SocketDealThread socketDealThread = new SocketDealThread(accept);
            socketDealThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
