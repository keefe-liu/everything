package practice.thread;

/**
 * Created by tingfang.liu on 2016/4/8.
 */
public class ConcurrentTest {
    static class MyThread extends Thread {
        private int myVar = 0;
        private MyTask task;

        public MyThread(MyTask task, String name) {
            this.setName(name);
            this.task = task;
        }

        @Override
        public void run() {
            MyTask.staticMethodA();
            MyTask.staticMethodB();
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t1 = new MyThread(task, "AAA");
        Thread t2 = new MyThread(task, "BBB");
        t1.start();
        t2.start();
    }
}
