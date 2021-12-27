package basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class condition {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        lock.lock();
        Condition condition = lock.newCondition();
        condition.await();
        condition.signal();
        condition.signalAll();
    }
}
