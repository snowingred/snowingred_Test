//package cn.tedu;
//
//import org.bouncycastle.util.encoders.Hex;
//import sun.misc.BASE64Encoder;
//
//import javax.crypto.*;
//import java.security.*;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.Map;
//
//public class TestJCEPassWod {
//
//    public static final String PUBLIC_KEY = "RSAPublicKey";
//    public static final String PRIVATE_KEY = "RSAPrivateKey";
//
//    public static Map<String,Object> initWordKey() throws NoSuchAlgorithmException {
//        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
//        rsa.initialize(1024);
//        KeyPair keyPair = rsa.generateKeyPair();
//        RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
//        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
//        HashMap<String, Object> keyMap = new HashMap<>();
//        keyMap.put(PUBLIC_KEY,rsaPublicKey);
//        keyMap.put(PRIVATE_KEY,rsaPrivateKey);
//
//        System.out.println("加密公钥"+rsaPublicKey);
//        System.out.println("加密私钥"+rsaPrivateKey);
//        return keyMap;
//    }
//
//    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//        String s="jiamineirong";
//        Map<String, Object> map = initWordKey();
//        RSAPublicKey pub = (RSAPublicKey) map.get(PUBLIC_KEY);
//        RSAPrivateKey pri = (RSAPrivateKey) map.get(PRIVATE_KEY);
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.ENCRYPT_MODE,pub );
//        byte[] bytes = cipher.doFinal(s.getBytes());
//        byte[] encode = Hex.encode(bytes);
//
//        String s1 = new String(encode);
//        System.out.println(s1);
//
//        Cipher priCipher = Cipher.getInstance("RSA");
//        priCipher.init(Cipher.DECRYPT_MODE,pri );
//        byte[] bytes1 = priCipher.doFinal(bytes);
//        System.out.println(new String(bytes1));
//
//
//
//        String s3="ji1mineirong";
//
//        MessageDigest md = MessageDigest.getInstance("md5");
//        byte[] buf = md.digest(s.getBytes());
//        // 字节数组不方便使用，所以一般会将其转换成一个字符串
//        BASE64Encoder encoder = new BASE64Encoder();
//        String str = encoder.encode(buf);
//        System.out.println(str);
//
//        byte[] buf3 = md.digest(s3.getBytes());
//        // 字节数组不方便使用，所以一般会将其转换成一个字符串
//        BASE64Encoder encoder3 = new BASE64Encoder();
//        String str3 = encoder3.encode(buf3);
//        System.out.println(str3);
//
//
//    }
//
//}
