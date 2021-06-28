package ThreadPool.SingleThread;

import java.beans.Transient;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName()+"running";
    }

    @Transient
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 20; i++) {
            TestCallable testCallable = new TestCallable();
            FutureTask<String> task = new FutureTask<>(testCallable);
            Thread thread = new Thread(task);
            thread.start();
            String s = task.get();
            System.out.println(s);
        }

    }
}
