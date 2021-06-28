package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


//创建一个单例的定长线程池,线程数为10,处理队列长度为200.
public class SingleThreadPool {

    //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
    private volatile static ExecutorService executorService=null;

    public SingleThreadPool(){
    }

    public static ExecutorService getSingleThreadPool(){
        // Double-Check idiom
        if (null==executorService){
            synchronized (SingleThreadPool.class){
                if (null==executorService){
                     executorService=new ThreadPoolExecutor(10, 10,
                            0L, TimeUnit.MILLISECONDS,
                            new LinkedBlockingQueue<Runnable>(2000));
                }
            }
        }
        return executorService;
    }}
