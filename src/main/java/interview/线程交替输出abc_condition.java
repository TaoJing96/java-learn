package interview;

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
