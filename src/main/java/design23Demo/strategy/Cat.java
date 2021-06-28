package design23Demo.strategy;
//这个累用来实现 生成猫对象
public class Cat  implements Comparable<Cat>{
    private int Height;
    private int Weight;


    public Cat(){}

    public  Cat(int height,int weight){
        this.Height=height;
        this.Weight=weight;
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
        return "Cat{" +
                "Height=" + Height +
                ", Weight=" + Weight +
                '}';
    }

    @Override
    public int compartTo(Cat c) {

        if (this.Weight>c.Weight){
            return 1;
        }else if(this.Weight<c.Weight){
            return -1;
        }
        return 0;
    }
}
