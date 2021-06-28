package design23Demo.Decorator.PlaneDecorator;

public class BasicPlane implements Plane {

    @Override
    public int price() {
        return 10000;
    }
    @Override
    public String function() {
        return "基础飞机";
    }
}
