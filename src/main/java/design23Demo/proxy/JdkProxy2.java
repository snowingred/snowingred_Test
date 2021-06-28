package design23Demo.proxy;

import design23Demo.factoryDesign.abstrctfactory.RunningTool;
import design23Demo.factoryDesign.abstrctfactory.factorymethod.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import java.lang.reflect.Proxy;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/*第一种，继承耦合度太高了
*  */
public class JdkProxy2 {
    public static void main(String[] args) {
//        Class moveAble[] ={Moveable.class};
//
//       JDk1.8以后使用  System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
//        JDk1.8使用
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Car car = new Car();
//        Moveable car;

        Moveable car1 = (Moveable) Proxy.newProxyInstance(Car.class.getClassLoader(), car.getClass().getInterfaces(), new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("log start");
                method.invoke(car,args);
                System.out.println("log end");
                return null;

            }
        });

        car1.go();
    }
}


