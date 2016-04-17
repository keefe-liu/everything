package practice.thread;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/8.
 */
public class DeadLock {
    private static class SyncObject {
        Object lock1 = new Object();
        Object lock2 = new Object();

        public void doWork() {
            synchronized (lock1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println("doWork() get lock1");
                synchronized (lock2) {
                    out.println("doWork() get lock2");
                }
            }
        }

        public void doOtherWork() {
            synchronized (lock2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println("doOtherWork() get lock1");
                synchronized (lock1) {
                    out.println("doOtherWork() get lock2");
                }
            }
        }
    }

    public static void main(String[] args) {
        SyncObject so = new SyncObject();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                so.doWork();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                so.doOtherWork();
            }
        };
        t1.start();
        t2.start();
    }
}
