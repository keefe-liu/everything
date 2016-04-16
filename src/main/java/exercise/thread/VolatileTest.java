package exercise.thread;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/9.
 */
public class VolatileTest {
    private static class SyncObject {
        private boolean continueRun = true;

        public void setContinueRun(boolean continueRun) {
            this.continueRun = continueRun;
        }

        public void doRun() {
            while (continueRun) {
                out.println("run");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Add add = new Add();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                add.add();
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                add.add();
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                add.add();
            }
        });
        t3.start();
        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
        }
        out.println(Add.getCount());

    }

    static class Add {
        private static AtomicInteger atomicInteger = new AtomicInteger(0);

        public static AtomicInteger getCount() {
            return atomicInteger;
        }

        private void add() {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicInteger.addAndGet(1);
            }
        }
    }
}
