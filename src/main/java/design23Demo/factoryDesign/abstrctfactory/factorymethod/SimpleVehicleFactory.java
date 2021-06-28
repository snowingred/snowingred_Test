package design23Demo.factoryDesign.abstrctfactory.factorymethod;
//简单工厂的可扩展行不好 毎加一个需要加方法
public class SimpleVehicleFactory {
    public Car createCar(){
//在这可以对car做起的修饰
        return new Car();
    }
    public Plane createPlane(){
//在这可以对Plane做起的修饰
        return new Plane();
    }
    public MagicCarret createMagicCarret(){
//在这可以对MagicCarret做起的修饰
        return new MagicCarret();
    }
}
