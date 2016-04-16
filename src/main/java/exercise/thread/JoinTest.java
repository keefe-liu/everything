package exercise.thread;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/12.
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int result = MyTask.doLongTimeWork();
            out.println(result);
        });
        Thread thread1= new Thread(()->{
            out.println("start");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.interrupt();
        });
        thread.start();
        thread1.start();
        thread.join(11111);
        out.println("after MyTask.doLongTimeWork()");
    }
}
