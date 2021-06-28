package BioNioAio.BioFirst;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 单发单收  Socket服务器
 */
public class BioSingleService {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
//      等待接收socket连接.直到有客户端连接
        Socket accept = serverSocket.accept();
//      获取socket里面的字节流数据
        InputStream is = accept.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg=null;
//      等待接收客户端传递过来的信息
        if((msg=br.readLine())!=null){
            System.out.println(msg);
        }
    }
}
