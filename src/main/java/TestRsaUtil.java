



import jceUtil.Rsa.RsaUtil;
import jceUtil.Rsa.RsaVo;

import java.util.*;


public class TestRsaUtil {


    public static void main(String[] args) throws Exception {

        RsaUtil rsaUtil = new RsaUtil();
        //干扰参数列表
        Map<String,String> paramsList = new LinkedHashMap<>();

        paramsList.put("A","A");
        paramsList.put("b","A");
        paramsList.put("c","A");

        //rsaPublicKey Rsa加密公钥      30819f300d06092a864886f70d010101050003818d003081890281810087368db82fdda0b5dbba89f399f17525f8cd02205cd47a5b2a934826a79e5d76a5d5d977b469f4c4ae96cfbd58b45a471e6cb01d6c559f9967dba9f1635d5448dce56e809f5eafd86a351980d119fb2a83fcc226874718ba333bf6f9b36a291900362b7b69e479bb10e636f1295dd9ce067021e9d025e88973997ff1f3d62d8f0203010001
        //digestSalt   Rsa摘要加密盐值  a061b85fbe504f6ea647ee608a6a2a
        String rsaPublicKey="30819f300d06092a864886f70d010101050003818d003081890281810087368db82fdda0b5dbba89f399f17525f8cd02205cd47a5b2a934826a79e5d76a5d5d977b469f4c4ae96cfbd58b45a471e6cb01d6c559f9967dba9f1635d5448dce56e809f5eafd86a351980d119fb2a83fcc226874718ba333bf6f9b36a291900362b7b69e479bb10e636f1295dd9ce067021e9d025e88973997ff1f3d62d8f0203010001";
        String digestSalt="a061b85fbe504f6ea647ee608a6a2a";

        //content内容明文 1640759850|2  如需传递其他参数以 | 号分割
        // 1640759850为原本的客户号customerId  2为渠道号,XXYChannelFlag
//        String content="1640772380|2";
        Map<String, String> map = new LinkedHashMap<>();
        map.put("customerId","1640772380");
        map.put("XXYChannelFlag","2");

        String content = map.toString();
        System.out.println(content);
        //加密后密文对象
        String s1 = rsaUtil.wrapContent(map, rsaPublicKey
                , digestSalt,paramsList);
        //加密后的短信链接应为  http：*********?params1=s1
        System.out.println("加解密后内容：---------"+s1);

        String s2 = rsaUtil.unWrapContent(s1, "30820276020100300d06092a864886f70d0101010500048202603082025c0201000281810087368db82fdda0b5dbba89f399f17525f8cd02205cd47a5b2a934826a79e5d76a5d5d977b469f4c4ae96cfbd58b45a471e6cb01d6c559f9967dba9f1635d5448dce56e809f5eafd86a351980d119fb2a83fcc226874718ba333bf6f9b36a291900362b7b69e479bb10e636f1295dd9ce067021e9d025e88973997ff1f3d62d8f02030100010281800373a01088a046befdb9f85590a37a531ad3d8ef0c8f9c0401c53abd49e02010ac5116391910ef5fa9f94d9a4ece63d396f23d58b2f0489fb8e801a198e0c40b029af384098c1abc1de13588feb91b5af0791331181ed02911b4b99f17a8f00a1b73cbb3f8f70927c2629097afa8776b2109e6f95ced828241fd913cb303eb89024100c7782536a0e95ca56a7a65c006804d869be4fa9df8760bfce74820d7ceb422bf020db2c194cb66b67c19f34a1ce4b698d610dc174a77662bfd242ead4ba49c63024100ad88814baae37485fe748e62a53f89d3acb831b3d079c946ba4f71c7b8f17126cf323db23b7750b739657072d4c04788f920afababa6551b6f7238e5bf3463e5024100bafa739fbebca1bce98fec7b515cc9cf49a91e082094bf6e057b4656258c141a0a99be9bd997c52380376f2864e73c070e7ae564ebc7fabd77608864a7c899530240709a693bce71b5c4d4ee910e15a87b28eda4c02bac15bab3b865a0b136a3050767df7405596cfce547cb39026a673284011462a984c273eb4f8fd0b7d4308cb90240183abe35c08b98824a3df44a969286c00e6a92f49d2f26fbbcfa328882af488b8ba9643f70cd0c5280b3e6e02bbfd886636f40593945d6a9038e7e0645406b53"
        ,"a061b85fbe504f6ea647ee608a6a2a");
        System.out.println("打印解密后内容：---------"+s2);


    }
}
