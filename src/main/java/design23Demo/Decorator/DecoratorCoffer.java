package design23Demo.Decorator;

public class DecoratorCoffer {
    public static void main(String[] args) {
        Coffer coffer = new Coffer();
        double cost = coffer.cost();
        System.out.println(cost);

        milk milk = new milk(coffer);
        double cost1 = milk.cost();
        System.out.println(cost1);

        Sogar sogar = new Sogar(milk);
        double cost2 = sogar.cost();
        System.out.println(cost2);
        System.out.println(sogar.info());
    }
}

interface Drink{
    double cost();
    String info();
}

class Coffer implements Drink{

    private String info="原味咖啡";

    @Override
    public double cost() {

        return 10;
    }

    @Override
    public String info() {

        return info;
    }
}

abstract  class DecoratorDrink implements  Drink{
    private Drink drink;
    public DecoratorDrink(Drink drink){
        this.drink=drink;
    }
    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return  this.drink.info();
    }
}

class milk extends DecoratorDrink{
    private Drink drink;

    public milk(Drink drink) {
        super(drink);
        this.drink=drink;
    }

    @Override
    public String info() {

        return drink.info()+"加入了牛奶";
    }

    @Override
    public double cost() {

        return drink.cost()*10;
    }

}
class Sogar extends DecoratorDrink{
    private Drink drink;

    public Sogar(Drink drink) {
        super(drink);
        this.drink=drink;
    }

    @Override
    public String info() {
        return drink.info()+"加入了糖";
    }

    @Override
    public double cost() {
        return drink.cost()*5;
    }

}
