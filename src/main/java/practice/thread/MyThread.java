package practice.thread;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/3.
 */
public class MyThread extends Thread {
    private static int i = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    public MyThread() {
    }

    @Override
    public void run() {
        try {
            out.println("start");
            Thread.sleep(20000);
            out.println("end");
        } catch (InterruptedException e) {
            out.println("mythread " + this.isInterrupted());
            e.printStackTrace();
        }
    }
}
