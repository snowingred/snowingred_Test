package cn.tedu;

import java.util.concurrent.atomic.AtomicInteger;

public class TestSycAndVolitalie {
/*   synchronized每次执行时,会清空工作内存,重新去获取共享内存中的变量值,  有输入我变了
 public static void main(String[] args) {
        SycAndVolatile sycAndVolatile = new SycAndVolatile();
        sycAndVolatile.start();

        for (;;){
            synchronized (sycAndVolatile){
            if (sycAndVolatile.isFalg()){
                System.out.println("我变了");
            }
        }
        }
    }*/

    /*   变量值在工作内存中没有发生改变为 false  所以不输出
 public static void main(String[] args) {
        SycAndVolatile sycAndVolatile = new SycAndVolatile();
        sycAndVolatile.start();

        for (;;){
            if (sycAndVolatile.isFalg()){
                System.out.println("我变了");
            }
        }
    }*/

    public static void main(String[] args) {
        new AtomicInteger();
        SycAndVolatile sycAndVolatile = new SycAndVolatile();
        sycAndVolatile.start();

        for (;;){
                if (sycAndVolatile.isFalg()){
                    System.out.println("我变了");
                }
        }
    }

    static class SycAndVolatile extends Thread{
        private volatile boolean falg =false;

        public boolean isFalg(){
            return falg;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(
                        "午时已到--------------"
                );
                falg=true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("flag="+falg);
        }
    }
}
