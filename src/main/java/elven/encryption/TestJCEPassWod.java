/*
package elven.encryption;

import RsaVo;
import org.bouncycastle.util.encoders.Hex;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestJCEPassWod {

    public static final String PUBLIC_KEY = "RSAPublicKey";
    public static final String PRIVATE_KEY = "RSAPrivateKey";


    public TestJCEPassWod() {

    }

    public static Map<String,Object> initWordKey() throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        rsa.initialize(1024);
        KeyPair keyPair = rsa.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
        HashMap<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY,rsaPublicKey);
        keyMap.put(PRIVATE_KEY,rsaPrivateKey);
//        System.out.println("加密公钥"+rsaPublicKey);
//        System.out.println("加密私钥："+rsaPrivateKey);

        byte[] encoded = rsaPublicKey.getEncoded();
        byte[] decode = Hex.encode(encoded);
        byte[] encoded1 = rsaPrivateKey.getEncoded();
        byte[] decode1 = Hex.encode(encoded1);

        System.out.println("加密公钥："+new String(decode));
        int length = new String(decode).length();
        System.out.println(length);
        System.out.println("加密私钥："+new String(decode1));
        return keyMap;
    }

    */
/**
     * @param content  待加密内容
     * @param rsaPublicKey 公钥密钥
     * @param digestSalt   摘要加密盐值
     * @return
     *//*

    public static RsaVo wrapContent(String content, String rsaPublicKey, String digestSalt) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, IOException, InvalidKeySpecException {

        rsaPublicKey="30819f300d06092a864886f70d010101050003818d0030818902818100baca4305db06c56a89aab1c5a01be1203cfcec299ce92f56e41da05fa8748373fd5ebc45d5f3d53715996537b66c4d4411b77e08ca642bafe79626352c1b6b5b6f65bcd47d0fd177176ad31c4cce0e9a6e63c76c02a70c86fcb2063edd1ab25100ead91db57d702aa8b80421dc2bdeb03fdefbbba21ede1046a20012eda395690203010001";
//        String rsaPriKey = "30820275020100300d06092a864886f70d01010105000482025f3082025b02010002818100baca4305db06c56a89aab1c5a01be1203cfcec299ce92f56e41da05fa8748373fd5ebc45d5f3d53715996537b66c4d4411b77e08ca642bafe79626352c1b6b5b6f65bcd47d0fd177176ad31c4cce0e9a6e63c76c02a70c86fcb2063edd1ab25100ead91db57d702aa8b80421dc2bdeb03fdefbbba21ede1046a20012eda3956902030100010281805b86da7a970d6554c3ea593b9e2dab0d71f4f8ff96fc880ecaae5db421c61dd78b128daca69ed91e29be45639c46cb418c70de180e9c30effbc98e2545dc95a89cb3568e4085bf9200383db52d86ffe7296af3268217a0dfa8ab5d59be4b2db522da3c917b07774d4aa8c72f0ffaaf0e086fe8da08eb927fadec45c45804d751024100e126f328cc9898aa807b7ed2b5e111a1a872572610975e87bec0211fd5598ef6952ac4cf5a4e43ffb987f2ec8519cd2e86636b9de38de0d0fdfbef59ee866205024100d461ca4595d2e3b197322e878973af6166b3d9fbf90b22d071610bdd10ea2b50880603540b176e02578bf3b6badb32a7ebf5fbfddff08d6c8f7eb1e06b464f1502404b8a29e2f261f036a44ccacc1f41980cc8db33ea0d7efbb447876695ab9b14a01e83eeec32bc378c40cf1fedc2ea5930d6dddc6968c35d3e413899a16ea99f9102406d30b1abc0f1a1bac63f3888da742db0e7fa8391f662714db55ced9a847dc033311bd64e393d9c837bbb2a5bc209bc2b75370c8d63baeb1aeb5379e425830a590240367d5f75878d3a2391c7115d78c3c0a85ca47db6113d4aaef1c7ce3bfae842aa2129127fb17612f160650da9c34f1b44ca9a6420a6ceb8cc41200e7ea8c51f63";
        byte[] encode = Hex.decode(rsaPublicKey);

        X509EncodedKeySpec encPubKeySpec = new X509EncodedKeySpec(encode);
        PublicKey pubKey = KeyFactory.getInstance("RSA").generatePublic(encPubKeySpec);
        //        rsa.init(128,);

        Map<String, Object> map = initWordKey();
        //根据公钥生成加密器
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pubKey);
        //对内容进行加密
        byte[] wrapContent = cipher.doFinal(content.getBytes());
        byte[] encode2 = Hex.encode(wrapContent);
        //加密内容完成
        String wrapContentStr = new String(encode2);

        //摘要加密开始
        String contentDigestSalt=content+digestSalt;
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] buf = md.digest(contentDigestSalt.getBytes());
        //摘要数组转换成一个字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String digestStr = encoder.encode(buf);
        RsaVo rsaVo = new RsaVo();
        rsaVo.setDigestStr(digestStr);
        rsaVo.setWrapContentStr(wrapContentStr);
        return rsaVo;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException, InvalidKeySpecException {
        String s="jiamineirong";
        Map<String, Object> map = initWordKey();
//        RSAPublicKey pub = (RSAPublicKey) map.get(PUBLIC_KEY);
//        RSAPrivateKey pri = (RSAPrivateKey) map.get(PRIVATE_KEY);

        String rsaPublicKey="30819f300d06092a864886f70d010101050003818d0030818902818100baca4305db06c56a89aab1c5a01be1203cfcec299ce92f56e41da05fa8748373fd5ebc45d5f3d53715996537b66c4d4411b77e08ca642bafe79626352c1b6b5b6f65bcd47d0fd177176ad31c4cce0e9a6e63c76c02a70c86fcb2063edd1ab25100ead91db57d702aa8b80421dc2bdeb03fdefbbba21ede1046a20012eda395690203010001";
        String rsaPriKey = "30820275020100300d06092a864886f70d01010105000482025f3082025b02010002818100baca4305db06c56a89aab1c5a01be1203cfcec299ce92f56e41da05fa8748373fd5ebc45d5f3d53715996537b66c4d4411b77e08ca642bafe79626352c1b6b5b6f65bcd47d0fd177176ad31c4cce0e9a6e63c76c02a70c86fcb2063edd1ab25100ead91db57d702aa8b80421dc2bdeb03fdefbbba21ede1046a20012eda3956902030100010281805b86da7a970d6554c3ea593b9e2dab0d71f4f8ff96fc880ecaae5db421c61dd78b128daca69ed91e29be45639c46cb418c70de180e9c30effbc98e2545dc95a89cb3568e4085bf9200383db52d86ffe7296af3268217a0dfa8ab5d59be4b2db522da3c917b07774d4aa8c72f0ffaaf0e086fe8da08eb927fadec45c45804d751024100e126f328cc9898aa807b7ed2b5e111a1a872572610975e87bec0211fd5598ef6952ac4cf5a4e43ffb987f2ec8519cd2e86636b9de38de0d0fdfbef59ee866205024100d461ca4595d2e3b197322e878973af6166b3d9fbf90b22d071610bdd10ea2b50880603540b176e02578bf3b6badb32a7ebf5fbfddff08d6c8f7eb1e06b464f1502404b8a29e2f261f036a44ccacc1f41980cc8db33ea0d7efbb447876695ab9b14a01e83eeec32bc378c40cf1fedc2ea5930d6dddc6968c35d3e413899a16ea99f9102406d30b1abc0f1a1bac63f3888da742db0e7fa8391f662714db55ced9a847dc033311bd64e393d9c837bbb2a5bc209bc2b75370c8d63baeb1aeb5379e425830a590240367d5f75878d3a2391c7115d78c3c0a85ca47db6113d4aaef1c7ce3bfae842aa2129127fb17612f160650da9c34f1b44ca9a6420a6ceb8cc41200e7ea8c51f63";

        byte[] encode = Hex.decode(rsaPublicKey);
        X509EncodedKeySpec encPubKeySpec = new X509EncodedKeySpec(encode);
        PublicKey pub = KeyFactory.getInstance("RSA").generatePublic(encPubKeySpec);

        byte[] encode1 = Hex.decode(rsaPriKey);
        PKCS8EncodedKeySpec encPubKeySpec1 = new PKCS8EncodedKeySpec(encode1);
        PrivateKey pri = KeyFactory.getInstance("RSA").generatePrivate(encPubKeySpec1);
*/
/*
        String format = pub.getFormat();
        String priFormat = pri.getFormat();
        System.out.println("format"+format);
        System.out.println("priFormat"+priFormat);*//*




        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pub );
        byte[] bytes = cipher.doFinal(s.getBytes());
        byte[] encode2 = Hex.encode(bytes);

        String s1 = new String(encode2);
        System.out.println(s1);

        Cipher priCipher = Cipher.getInstance("RSA");
        priCipher.init(Cipher.DECRYPT_MODE,pri );
        byte[] bytes1 = priCipher.doFinal(bytes);
        System.out.println(new String(bytes1));



        String s3="ji1mineirong";

        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] buf = md.digest(s.getBytes());
        // 字节数组不方便使用，所以一般会将其转换成一个字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String str = encoder.encode(buf);
        System.out.println(str);

        byte[] buf3 = md.digest(s3.getBytes());
        // 字节数组不方便使用，所以一般会将其转换成一个字符串
        BASE64Encoder encoder3 = new BASE64Encoder();
        String str3 = encoder3.encode(buf3);
        System.out.println(str3);


        String s5="jiamineirong|1111";
        String[] split = s5.split("\\|");
        System.out.println(Arrays.toString(split));

    }

}
*/
