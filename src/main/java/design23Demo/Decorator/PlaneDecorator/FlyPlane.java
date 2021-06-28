package design23Demo.Decorator.PlaneDecorator;

public class FlyPlane extends DecoratorPlane {

    public FlyPlane(Plane plane) {
        super(plane);
    }

    @Override
    public int price() {
        return (int) (super.plane.price()*1.1);
    }

    @Override
    public String function() {
        return super.plane.function()+"加装了喷射器";
    }
}
