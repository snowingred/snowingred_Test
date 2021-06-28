package design23Demo.ChainResponsibility.ParamsVerifyChain;

import java.util.Map;

public class DateVerify implements ParamsVerifyChain {

    @Override
    public boolean ParamsVerify(Map ParamsMap) {
        String date = (String) ParamsMap.get("Date");
        if (date.equals("20210528")){
            return false;
        }
        return true;
    }
}
