package design23Demo.factoryDesign.abstrctfactory.factorymethod;

public class Main {
    public static void main(String[] args) {
        Moveable  m= (Moveable) new CarFactory();
        m.go();
    }
}
