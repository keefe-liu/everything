package practice.thread;

import java.security.SecureRandom;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/8.
 */
public class MyTask {
    public static int doLongTimeWork() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SecureRandom().nextInt();
    }

    public synchronized static void staticMethodA() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("method a");
        }
    }

    public synchronized static void staticMethodB() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println("method b");
        }
    }

    public void doPrint() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }
}
