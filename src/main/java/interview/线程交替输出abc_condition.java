package interview;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//利用condition
public class 线程交替输出abc_condition {

    private static final Lock lock = new ReentrantLock();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();
    private static final Condition condition3 = lock.newCondition();
    private static int count = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    while ((count % 3) != 1) {
                        condition2.await();
                    }
                    System.out.println('b');
                    count++;
                    condition3.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
        new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    while ((count % 3) != 2) {
                        condition3.await();
                    }
                    System.out.println('c');
                    count++;
                    condition1.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t3").start();
        new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    while ((count % 3) != 0) {
                        condition1.await(); //释放锁
                    }
                    System.out.println('a');
                    count++;
                    condition2.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();
    }
}

//利用阻塞队列
class solution2 {

    private static final BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(1);

    private static final BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(1);

    private static final BlockingQueue<Integer> queue3 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        queue1.offer(1);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue1.take();
                    System.out.println(1 + i * 10);
                    Thread.sleep(100);
                    queue2.offer(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue2.take();
                    System.out.println(2+ i * 10);
                    Thread.sleep(100);
                    queue3.offer(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue3.take();
                    System.out.println(3+ i * 10);
                    System.out.println("-------------");
                    Thread.sleep(100);
                    queue1.offer(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
