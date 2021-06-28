package design23Demo.proxy;

import design23Demo.factoryDesign.abstrctfactory.RunningTool;
/*第一种，改变吗继承
*  */
public class Proxy1 {
    public static void main(String[] args) {
        CarLog carLog = new CarLog();
        carLog.go();
    }
}




class CarLog extends Car {
    public void go() {
        System.out.println("go log");
        System.out.println("Car dididi");
        System.out.println("go log");
    }
}