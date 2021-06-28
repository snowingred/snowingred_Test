package cn.tedu;

import io.netty.handler.codec.http.HttpRequest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class TestSession {
    public static void main(String[] args) throws IOException {
        String s="aaaAAA";
        char a='A';
        char B = (char) (a ^ 32);
        System.out.println(B);
        byte[] bytes = s.getBytes();
        System.out.println(Arrays.toString(bytes));

       /* FileOutputStream fileOutputStream = new FileOutputStream("D://abc/file.txt");
        fileOutputStream.write(s.getBytes());
*/
        FileInputStream fileInputStream = new FileInputStream("D://abc/file.txt");
        byte[] bytes2 = new byte[8];
        int len;
        while((len=fileInputStream.read(bytes2))!=-1){
            String s1 = new String(bytes2,0,len);
            System.out.print(s1);
        }






    }
}