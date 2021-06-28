package design23Demo.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class CglibProxy {
    public static void main(String[] args) {
        CglibCar cglibCar = new CglibCar();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibCar.class);
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("Cgliblog start");
                method.invoke(cglibCar,args);
                System.out.println("Cgliblog end");
                return null;
            }
        });
        CglibCar car = (CglibCar)enhancer.create();
        car.go();
    }

}
