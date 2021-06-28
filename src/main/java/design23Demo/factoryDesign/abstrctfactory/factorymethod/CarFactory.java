package design23Demo.factoryDesign.abstrctfactory.factorymethod;

public class CarFactory {
    public Moveable createCar(){
//在这可以对car做起的修饰
        return new Car();
    }
}
