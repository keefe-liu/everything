package practice.thread;

/**
 * Created by tingfang.liu on 2016/4/23.
 */
public class PAC {
    private static String product;
    private static Object lock = new Object();

    private static class Producer {
        public void produce() {
            synchronized (lock) {
                if (product != null) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                product = "product";
                System.out.println("produce a product ---- " + product);
                lock.notify();
            }
        }
    }

    private static class Consumer {
        public void consume() {
            synchronized (lock) {
                if (product == null) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("consume a product ---- " + product);
                product = null;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    producer.produce();
                }
            }
        });
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    consumer.consume();
                }
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
