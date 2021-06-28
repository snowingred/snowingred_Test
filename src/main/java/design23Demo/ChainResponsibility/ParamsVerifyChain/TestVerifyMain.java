package design23Demo.ChainResponsibility.ParamsVerifyChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestVerifyMain {
    public static void main(String[] args) {
        //模拟校验数据输入
        Map<String, Object> map = new HashMap<>();
        map.put("Date", "20210527");
        map.put("userId", "zhou1");
        //组装责任链条
        List<ParamsVerifyChain> paramsVerifyChainList =new ArrayList<>();
        paramsVerifyChainList.add(new UserIdVerify());
        paramsVerifyChainList.add(new DateVerify());
        //责任链实现参数校验
        VerifyImpl verify = new VerifyImpl();
        boolean b = verify.ParamsVerify(paramsVerifyChainList, map);
        System.out.println(b);
    }
}
