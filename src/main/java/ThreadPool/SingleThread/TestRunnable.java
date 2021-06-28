package ThreadPool.SingleThread;

public class TestRunnable  implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"running");
    }



    public static void main(String[] args) {
        It c=(e)->{
            System.out.println(e+"1111");
        };
        c.hi("11111");
}

    interface It{	//函数式接口（只有一个抽象方法）
        void hi(String s);	//此接口只有个抽象方法hi(String s)
    }
}