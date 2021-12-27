package basic;

import java.util.concurrent.ArrayBlockingQueue;

public class blockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
        queue.put(2);
        queue.poll();
    }
}
