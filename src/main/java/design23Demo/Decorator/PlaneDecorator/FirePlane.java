package design23Demo.Decorator.PlaneDecorator;

public class FirePlane extends DecoratorPlane {

    Plane plane;

    public FirePlane(Plane plane) {
        super(plane);
        this.plane=plane;
    }

    @Override
    public int price() {
        return this.price()*10;
    }

    /* @Override
    public int price() {
        return super.plane.price()*10;
    }

    @Override
    public String function() {
        return super.plane.function()+"加装了火力";
    }*/

}
