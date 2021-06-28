package cn.tedu;

public class TestThreadABC {
    private static volatile int num = 1;
    private static final int maxNum = 100;


    public static void main(String[] args) {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (num > maxNum) {
                        break;
                    }
                    if (num % 10 != 0) {
                        if (num % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + "---------" + num);
                            num++;
                        } else {
                            Thread.yield();
                        }
                    } else {
                        Thread.yield();
                    }
                }}
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    if (num > maxNum) {
                        break;
                    }
                    if (num % 10 != 0) {
                        if (num % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + "---------" + num);
                            num++;
                        } else {
                            Thread.yield();
                        }
                    } else {
                        Thread.yield();

                    }
                }  }
        });

        Thread threadC = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (num > maxNum) {
                        break;
                    }
                    if (num % 10 == 0) {
                        System.out.println(Thread.currentThread().getName() + "---------" + num);
                        num++;
                    } else {
                        Thread.yield();
                    } }
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();

    }



}
