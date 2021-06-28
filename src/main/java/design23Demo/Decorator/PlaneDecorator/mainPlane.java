package design23Demo.Decorator.PlaneDecorator;

public class mainPlane {
    public static void main(String[] args) {
        BasicPlane basicPlane = new BasicPlane();
        FirePlane firePlane = new FirePlane(basicPlane);
        int price = firePlane.price();
        String function = firePlane.function();
        System.out.println(price);
        System.out.println(function);

        FlyPlane flyPlane = new FlyPlane(firePlane);
        int flyPlanePrice = flyPlane.price();
        String flyPlaneFunction = flyPlane.function();
        System.out.println(flyPlanePrice);
        System.out.println(flyPlaneFunction);
    }
}
