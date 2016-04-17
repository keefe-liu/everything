package practice.thread;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/12.
 */
public class MultiProducer {
    private static Object product = null;

    private static class Producer {
        private Object lock;

        public Producer(Object lock) {
            this.lock = lock;
        }

        public void produce() {
            try {
                while (true) {
                    synchronized (lock) {
                        while (product != null) {
                            out.println("producer wait");
                            lock.wait();
                        }
                        product = "123";
                        out.println("produce " + product);
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer {
        private Object lock;

        public Consumer(Object lock) {
            this.lock = lock;
        }

        public void consume() {
            try {
                while (true) {
                    synchronized (lock) {
                        while (product == null) {
                            out.println("consumer wait");
                            lock.wait();
                        }
                        product = null;
                        out.println("consume " + product);
                        lock.notify();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] producers = new Thread[2];
        Thread[] consumers = new Thread[2];
        Object lock = new Object();
        for (int i = 0; i < 2; i++) {
            producers[i] = new Thread(() -> {
                new Producer(lock).produce();
            });
            producers[i].setName("producer " + i);
            consumers[i] = new Thread(() -> {
                new Consumer(lock).consume();
            });
            consumers[i].setName("consumer " + i);

        }
        for (int i = 0; i < 2; i++) {
            producers[i].start();
            consumers[i].start();
        }
        Thread.sleep(2000);
        Thread[] active = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(active);
        for (Thread t : active) {
            out.println(t.getName() + " " + t.getState());
        }
    }
}
