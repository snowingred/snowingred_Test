package ThreadPool;

import javax.swing.plaf.PanelUI;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool {

    public  int index=0;

    public void TestThradPool(){
        List<String> Strlist = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Strlist.add("这是"+i);
        }
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService =  new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(2));
        Executors.newScheduledThreadPool(10);
        Executors.newSingleThreadExecutor();
        try{
//            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    while (index<Strlist.size()){

                        System.out.println(Thread.currentThread().getName()+ Strlist.get(index++));
                        synchronized (this){
                            index++;
                        }
//
                    }
                });
//            }
        }catch (Exception
                e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
            index=0;
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        threadPool.TestThradPool();
    }
}
