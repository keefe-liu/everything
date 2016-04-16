package exercise.thread;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/12.
 */
public class ThreadLocalTest {

    public static class IThreadLocal extends ThreadLocal {
        @Override
        public Object initialValue() {
            return "initialValue";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal threadLocal = new IThreadLocal();
        out.println(threadLocal.get());
        Thread t1 = new Thread(() -> {
            threadLocal.set("t1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println(threadLocal.get());
        });
        Thread t2 = new Thread(() -> {
            out.println(threadLocal.get());
            threadLocal.set("t2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.println(threadLocal.get());
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        out.println(threadLocal.get());
    }
}
