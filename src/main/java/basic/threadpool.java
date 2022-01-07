package basic;

import java.util.concurrent.*;

public class threadpool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 3, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        executor.execute(() -> {
            System.out.println(1);
        });
        Future<?> future = executor.submit(() -> {
            System.out.println(1);
            return "t2 return";
        });
        Object o = future.get(); //同步等待返回值ca
        System.out.println(o);
    }
}
