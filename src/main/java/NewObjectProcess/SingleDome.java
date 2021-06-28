package NewObjectProcess;

public class SingleDome {

    private static final SingleDome s=new SingleDome();

    private SingleDome(){}

    private static SingleDome getInstance(){
        return  s;
    }
    public  void n(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        SingleDome s1 = SingleDome.getInstance();
        SingleDome s2 = SingleDome.getInstance();
        System.out.println(s1==s2);
    }
}
