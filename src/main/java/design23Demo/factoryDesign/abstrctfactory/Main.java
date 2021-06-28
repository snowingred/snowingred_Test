package design23Demo.factoryDesign.abstrctfactory;

public class Main {
    public static void main(String[] args) {
        MagicCarret magicCarret = new MagicCarret();
        magicCarret.go();
        Mushroom mushroom = new Mushroom();
        mushroom.eat();
        Magicwand Magicwand = new Magicwand();
        Magicwand.shoot();
    }
}
