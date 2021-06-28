package cn.tedu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TestMap  {
    //返回数据集
    Map<String, Object> respMap = new HashMap<>();

    //esb请求处理数据集
    Map<String, Object> reqDate = new HashMap<>();
    //esb请求参数数据集
    Map<String, String> reqParams = new HashMap<>();
    //esb报文字段映射
    Map<String, Map<String, String>> esbSendMap = new HashMap<>();
    //body字段映射
    Map<String, String> req_body = new HashMap<>();

    //接收esb响应参数集
    Map respDate = new HashMap<String, Object>();
    //响应参数映射集
    Map esbReceiveMap = new HashMap<String, Map<String, String>>();
    //响应BODY映射
    Map resp_body = new HashMap<String, String>();

    public TestMap() {
        this.respMap = new HashMap<>();
        this.reqDate = new HashMap<>();
        this.reqParams = new HashMap<>();
        this.esbSendMap = new HashMap<>();
        this.req_body = new HashMap<>();
        this.respDate =  new HashMap<String, Object>();
        this.esbReceiveMap = new HashMap<String, Map<String, String>>();
        this.resp_body = new HashMap<String, String>();
    }

    public void put(){

    }

/*    public static void main(String[] args) {
        HashMap<String, Map> StringHashMap = new HashMap<>();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("1",null);
        stringStringHashMap.put("1","1");
        StringHashMap.put("APP_HEAD",stringStringHashMap);
        Map<String, String> HashMap = null != StringHashMap.get("APP_HEAD") ? StringHashMap.get("APP_HEAD") : new HashMap<>();
        System.out.println(HashMap.get("1"));

        Integer a=1;
        Integer b=2;
        Integer c=2;
         a = b != c ? 4 : 5;


    }*/


    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
        Integer c=2;
        a = b != c ? 4 : 5;
        System.out.println("a---------"+a);
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }
    }


