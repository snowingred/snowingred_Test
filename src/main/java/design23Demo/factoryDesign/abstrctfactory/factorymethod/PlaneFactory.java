package design23Demo.factoryDesign.abstrctfactory.factorymethod;

public class PlaneFactory {
    public Plane createCar(){
//在这可以对Plane做起的修饰
        return new Plane();
    }
}
