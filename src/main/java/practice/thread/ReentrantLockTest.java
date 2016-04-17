package practice.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/12.
 */
public class ReentrantLockTest {

    private class Service {
        private Lock lock = new ReentrantLock();

        public void service() throws InterruptedException {
            lock.lock();
            Condition condition = lock.newCondition();
            condition.await();
            out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(300);
            out.println(Thread.currentThread().getName() + " end");
            condition.signal();
            lock.unlock();
        }

        public void method() throws InterruptedException {
            lock.lock();
            out.println(Thread.currentThread().getName() + "other start ");
            Thread.sleep(300);
            out.println(Thread.currentThread().getName() + "other end ");
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Service service = new ReentrantLockTest().new Service();
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                try {
                    service.service();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].setName("thread " + i);
        }
        for (int i = 5; i < 10; i++) {
            threads[i] = new Thread(() -> {
                try {
                    service.method();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].setName("thread " + i);
        }
        for (int i = 9; i >= 0; i--) {
            threads[i].start();
        }
    }
}
