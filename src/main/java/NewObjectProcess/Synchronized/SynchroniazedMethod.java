package NewObjectProcess.Synchronized;

public class SynchroniazedMethod {
    synchronized public static void printA() {
        try {
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "进入printA");
            Thread.sleep(3000);
            System.out.println("线程名称为：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void method1() {
        synchronized (mutex.class) {
            System.out.println(mutex.class);
        }
    }

    public void method() {
        synchronized (this) {
            System.out.println("----");
        }
    }
}
class mutex{

}