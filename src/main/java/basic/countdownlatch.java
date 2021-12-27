package basic;

import java.util.concurrent.CountDownLatch;

public class countdownlatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2); //state=2
        new Thread(() -> {
            System.out.println("t1");
            countDownLatch.countDown();//state--，到0会唤醒等待队列
        }, "t1").start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2");
            countDownLatch.countDown();
        }, "t2").start();
        System.out.println("main1");
        countDownLatch.await();//放入等待队列，mode为shared
        System.out.println("main2");
    }
}
