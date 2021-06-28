package design23Demo.Singleton;

// 线程安全的懒汉式单例
public class SingleClass {

    //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
    private static volatile SingleClass singleton3;

    private SingleClass() {
    }

    public static SingleClass getSingleton3() {
        // Double-Check idiom
        if (singleton3 == null) {
            synchronized (SingleClass.class) {       // 1
                // 只需在第一次创建实例时才同步
                if (singleton3 == null) {       // 2
                    singleton3 = new SingleClass();      // 3
                }
            }
        }
        return singleton3;
    }
}