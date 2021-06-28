package design23Demo.strategy;
//这个累用来实现 生成猫对象
public class Dog implements Comparable<Dog>{
     int Food;


    public Dog(){}

    public Dog(int food){
        this.Food=food;
    }
//    public int compareTo(Object o){
//       Cat c= (Cat)o;
//      if (this.Weight>c.Weight){
//          return 1;
//      }else if(this.Weight<c.Weight){
//          return -1;
//      }
//        return 0;
//    };

    @Override
    public String toString() {
        return "Dog{" +
                "Food=" + Food +
                '}';
    }

    @Override
    public int compartTo(Dog c) {

        if (this.Food>c.Food){
            return 1;
        }else if(this.Food<c.Food){
            return -1;
        }
        return 0;
    }
}
