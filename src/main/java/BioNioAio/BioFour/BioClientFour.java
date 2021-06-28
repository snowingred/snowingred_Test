package BioNioAio.BioFour;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * socketClient多收多发
 */
public class BioClientFour {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            OutputStream outputStream = socket.getOutputStream();
            PrintStream pt = new PrintStream(outputStream);
//          获取键盘输入扫描器
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请说------");
//              扫描器下一行
                String s = scanner.nextLine();
                pt.println(s);
                pt.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
