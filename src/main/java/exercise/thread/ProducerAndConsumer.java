package exercise.thread;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/10.
 */
public class ProducerAndConsumer {
    private Object lock = new Object();
    private List<Integer> products = new ArrayList<>();
    private final SecureRandom secureRandom = new SecureRandom();
    private int amount = 10;

    public ProducerAndConsumer() {
        for (int i = 0; i < 10; i++) {
            products.add(i);
        }
    }

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (products.size() >= 10) {
                    lock.wait();
                }
                products.add(amount);
                out.println("produce " + amount++);
                lock.notify();
                Thread.sleep(2000);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (products.size() <= 5) {
                    out.println("consumer wait for producer");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                out.println("consume product " + products.remove(0));
                Thread.sleep(5);
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();
        Thread producer = new Thread(() -> {
            try {
                producerAndConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                producerAndConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.start();
        Thread.sleep(10);
        producer.start();
    }
}
