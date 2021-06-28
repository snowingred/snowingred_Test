package design23Demo.ChainResponsibility.ParamsVerifyChain;

import com.sun.org.apache.bcel.internal.generic.I2F;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VerifyImpl {

    public VerifyImpl() {
    }

    public boolean ParamsVerify(List<ParamsVerifyChain> paramsVerifyChainList, Map paramsMap){
        for (int i = 0; i < paramsVerifyChainList.size() ; i++) {
            boolean b = paramsVerifyChainList.get(i).ParamsVerify(paramsMap);
            if (!b){
                return false;
            }
        };
        return true;
    }
}
