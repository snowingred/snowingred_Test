package BioNioAio.BioFirst;

import java.io.*;
import java.net.Socket;


/**
 * 单发单收  Socket客户端
 */
public class BisSingleClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            OutputStream os = socket.getOutputStream();
      /*    结论：不能用。为什么不能用呢
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("1111");
            bw.write("2222");
            bw.flush();*/
            PrintStream ps = new PrintStream(os);
            ps.println("hello world");
//          缓存区数据 刷新出去
            ps.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
