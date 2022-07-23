package jvm;

/**
 * @author jingtao
 * @date 2022/7/20 21:05
 */
//-Xms50M -Xmx50M -verbose:gc
public class DeadLockTest {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("t1");
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("t2");
                }
            }
        }).start();
        System.out.println("main");
    }
}
