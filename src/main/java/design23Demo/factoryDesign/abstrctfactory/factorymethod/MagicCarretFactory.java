package design23Demo.factoryDesign.abstrctfactory.factorymethod;

public class MagicCarretFactory {
    public MagicCarret createCar(){
//在这可以对MagicCarret做起的修饰
        return new MagicCarret();
    }
}
