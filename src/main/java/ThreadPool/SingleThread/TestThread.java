package ThreadPool.SingleThread;

public class TestThread  extends  Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Thread run");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            TestThread testThread = new TestThread();
            testThread.start();
        }
    }

}

