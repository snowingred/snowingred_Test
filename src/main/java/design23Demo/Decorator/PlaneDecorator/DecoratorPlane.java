package design23Demo.Decorator.PlaneDecorator;

public abstract class DecoratorPlane implements Plane{

    Plane plane;

    public DecoratorPlane(Plane plane) {
        this.plane = plane;
    }

   public int price(){
       return this.plane.price();
    };

    public String function(){
        return this.plane.function();
    };

}
