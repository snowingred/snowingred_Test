package cn.tedu;

import org.bouncycastle.util.encoders.Hex;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class TestPassword {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        String SECRECT = "passwrsfffdfsdd二 而";
        String Pvalue="这是明文内范德wrr2432343i,hew 萨发d w 的fds ds ssadasd是容";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());
        Pvalue=Pvalue+"|"+date;
        //密钥加密规则
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //初始化密钥
        keyGenerator.init(128,new SecureRandom(SECRECT.getBytes()));
        //获取密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //密钥工具构造
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), "AES");
        //根据密钥生成加密器
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec,
                new IvParameterSpec(new byte[16]));
        //明文加密
        SecretKeySpec key = new SecretKeySpec(Pvalue.getBytes(), "AES");
        byte[] wrap = cipher.doFinal(Pvalue.getBytes());
//        byte[] wrap = cipher.wrap(key);
        byte[] encode = Hex.encode(wrap);
        String s = new String(encode);
        System.out.println(s);
        System.out.println(Arrays.toString(Hex.encode(wrap)));
        System.out.println(Hex.encode(wrap));
        System.out.println(s.length());

        //解密步骤
        byte[] rawKey = Hex.decode(s);
        KeyGenerator decodeKeyGenerator = KeyGenerator.getInstance("AES");
        //初始化密钥生成器，指定密钥长度为128，指定随机源的种子为指定的密钥(这里是"passward")
        decodeKeyGenerator.init(128, new SecureRandom(SECRECT.getBytes()));
        SecretKey decodeSecretKey = decodeKeyGenerator.generateKey();
        SecretKeySpec decodeSecretKeySpec = new SecretKeySpec(decodeSecretKey.getEncoded(), "AES");
        Cipher decodeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        decodeCipher.init(Cipher.DECRYPT_MODE, decodeSecretKeySpec,
                new IvParameterSpec(new byte[16]));
//        SecretKey decodeKey = (SecretKey) decodeCipher.unwrap(rawKey, "AES", Cipher.SECRET_KEY);
        byte[] bytes = decodeCipher.doFinal(wrap);
        System.out.println(new String(bytes));
//        System.out.println(new String(decodeKey.getEncoded()));
    String s1
            ="764ccde3a81b329ed61342f2254b6cc93dd88d590a92ae1ef6572da03f2b6f9b0a7001318b9b3744d25594fbdda30562";

        System.out.println(s1.getBytes().length);


    }
}
//9bcc6c4571eb4e17c4b96f5b96924a5f9bb3318a709dc9f50d5f7416a8fb8ddb