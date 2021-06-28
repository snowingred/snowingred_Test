package BioNioAio.BioFour;

import BioNioAio.Biothree.SocketDealThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * socket服务器启动多线程处理多个客户端,伪异步
 * 利用线程池和阻塞队列实现
 */
public class BisServiceFour {
    public static void main(String[] args) {

        try {

            System.out.println("服务器启动");
            ServerSocket serverSocket = new ServerSocket( 9999);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                    0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>());
            while (true){
                Socket accept = serverSocket.accept();
                BioServiceRunnable bioServiceRunnable = new BioServiceRunnable(accept);
                threadPoolExecutor.execute(bioServiceRunnable);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
 
}
