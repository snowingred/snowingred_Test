package cn.tedu;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

public class TestCiher {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        System.out.println(instance);
    }
}
