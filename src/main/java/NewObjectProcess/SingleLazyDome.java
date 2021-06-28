package NewObjectProcess;

public class SingleLazyDome {

    private static volatile   SingleLazyDome s;

    private SingleLazyDome(){}

    private static SingleLazyDome getInstance(){

        if (s==null){
        synchronized (SingleLazyDome.class){
            if (s==null){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                s=new SingleLazyDome();
            }
        }
        }
        return  s;
    }
    public  void n(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        SingleLazyDome s1 = SingleLazyDome.getInstance();
        SingleLazyDome s2 = SingleLazyDome.getInstance();
        System.out.println(s1==s2);
    }

}
