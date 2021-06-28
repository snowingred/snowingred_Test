
package jceUtil.Rsa;
import org.bouncycastle.util.encoders.Hex;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * RSA非对称加密算法
 */

public class RsaUtil {

    //公钥
    public static final String PUBLIC_KEY = "RSAPublicKey";
    //私钥
    public static final String PRIVATE_KEY = "RSAPrivateKey";

    public RsaUtil() {

    }


/**
     * @return 初始化公钥私钥,获取新的公私钥
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */

    public static Map<String,Object> initWordKey() throws NoSuchAlgorithmException {
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        rsa.initialize(1024);
        KeyPair keyPair = rsa.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
        HashMap<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY,rsaPublicKey);
        keyMap.put(PRIVATE_KEY,rsaPrivateKey);
        return keyMap;
}


/**
     * RSA内容加密（附当前时间戳/摘要加密后密文）
     * @param content  待加密内容
     * @param rsaPublicKey 公钥密钥
     * @param digestSalt   摘要加密盐值
     * @return
     */

    public String wrapContent(Map content, String rsaPublicKey, String digestSalt) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, IOException, InvalidKeySpecException {
        String rsaVo = wrapContent(content, rsaPublicKey, digestSalt, null);
        return rsaVo;
    };



/**
     * RSA内容加密（附当前时间戳/摘要加密后密文）
     * @param content  待加密内容
     * @param rsaPublicKey 公钥密钥
     * @param digestSalt   摘要加密盐值
     * @param paramList    干扰参数
     * @return
     */

    public String wrapContent(Map content, String rsaPublicKey, String digestSalt, Map paramList) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, IOException, InvalidKeySpecException {

        //公钥密文转化为公钥对象
        byte[] encode = Hex.decode(rsaPublicKey);
        X509EncodedKeySpec encPubKeySpec = new X509EncodedKeySpec(encode);
        PublicKey pubKey = KeyFactory.getInstance("RSA").generatePublic(encPubKeySpec);

        //根据公钥生成加密器
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pubKey);

        //内容与时间参数,盐值组装
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = simpleDateFormat.format(new Date());

        //组装加密内容
        content.put("date",date);

      if (null!=paramList&&paramList.size()>0){
        Iterator<Map.Entry<String, String>> it = paramList.entrySet().iterator();
        //获得map中的每一个键值对
        while (it.hasNext()){
            Map.Entry entry = it.next();
            String name = entry.getKey().toString();
            String value =entry.getValue().toString();
            content.put(name,value);
        }
        }
        //摘要加密,返回摘要加密后的字符串
        String contentDigest = content.toString();
        String digestStr = contextDigest(contentDigest, digestSalt);

        //摘要加密密文和明文内容拼接加密
        content.put("digestStr",digestStr);
        contentDigest = content.toString();

        //对内容进行加密
        byte[] wrapContent = cipher.doFinal(contentDigest.getBytes());
        byte[] encodeContent = Hex.encode(wrapContent);
        String wrapContentStr = new String(encodeContent);

        return wrapContentStr;
    }


/**
     * RSA内容解密（对比摘要加密后密文）
     * @param rsaPriKey  私钥
     * @param digestSalt 摘要加密盐值
 *     return -1 代表失败
     */

    public  String unWrapContent(String wrapContentStr,String rsaPriKey,String digestSalt) throws Exception {
        //参数校验
        if (null==digestSalt||null==rsaPriKey||null==wrapContentStr){
            return  "-1";
        }
        //私钥密文转化为私钥对象
        byte[] encode = Hex.decode(rsaPriKey);
        PKCS8EncodedKeySpec encpriKeySpec = new PKCS8EncodedKeySpec(encode);
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(encpriKeySpec);

        //根据私钥生成加密器
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);

        //对加密内容进行解码
        byte[] encodeWrapContentStr = Hex.decode(wrapContentStr.getBytes());
        byte[] unWrapContent = cipher.doFinal(encodeWrapContentStr);

        //摘要加密,返回摘要加密后的字符串
        String unWrapContentStr = new String(unWrapContent);

        Map<String,String> map = StringToMap(unWrapContentStr);
        String digestStr = map.get("digestStr");
        map.remove("digestStr");
        unWrapContentStr = map.toString();

        String unWrapdigestStr = contextDigest(unWrapContentStr, digestSalt);
        if (!unWrapdigestStr.equals(digestStr)){
            throw new Exception("解析错误,传输内容被修改");
        }
        return unWrapContentStr;
    }


/**
     * 对内容进行带盐值的摘要加密
     * @param contentDigest  内容
     * @param digestSalt  盐值
     * @return
     */

    public  String contextDigest(String contentDigest, String digestSalt) throws NoSuchAlgorithmException {
        //组装加盐值的内容
        String contentDigestSalt=contentDigest+"|"+digestSalt;
        //摘要加密开始
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] buf = md.digest(contentDigestSalt.getBytes());
        //转换成一个字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String digestStr = encoder.encode(buf);
        return digestStr;
    }


    /**
     * 字符串转化为map
     * @param content 明文内容
     * @return
     */
    private Map<String,String> StringToMap(String content){
        Map<String,String> countryMap = new LinkedHashMap<>();
        String cms =content.replace("{", "").replace("}", "");
        String[] countryMapStr = cms.split(",");
//      遍历,存入map
        for(String s:countryMapStr){
            int index = s.indexOf("=");
            String mf = s.substring(0,index).trim();
            String ml = s.substring(index+1).trim();
            countryMap.put(mf, ml);
         }
        return countryMap;
    }
}