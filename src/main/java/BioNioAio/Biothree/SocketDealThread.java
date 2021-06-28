package BioNioAio.Biothree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketDealThread extends Thread{

    private Socket socket;

    public SocketDealThread() {
    }

    public SocketDealThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        InputStream is = null;
        try {
            is = socket.getInputStream();
            BufferedReader bd = new BufferedReader(new InputStreamReader(is));
            String msg=null;
//          循环等待socket内容发送
            while((msg=bd.readLine())!=null){
                System.out.println("服务器收到信息=="+msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        };

    }
}
