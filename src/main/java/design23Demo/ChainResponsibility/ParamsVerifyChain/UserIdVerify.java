package design23Demo.ChainResponsibility.ParamsVerifyChain;

import java.util.Map;

public class UserIdVerify implements ParamsVerifyChain {

    @Override
    public boolean ParamsVerify(Map ParamsMap) {
        String userId = (String) ParamsMap.get("userId");
        if (userId.equals("zhou")){
            return false;
        }
        return true;
    }
}
