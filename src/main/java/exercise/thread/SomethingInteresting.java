package exercise.thread;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/3.
 */
public class SomethingInteresting {

    static class SyncObject {
        private Integer instanceVar = 0;
        private Object lock = new Object();

        public void add() {
            Integer privateVar = 0;
            privateVar = MyTask.doLongTimeWork();
            synchronized (this) {
                //Fixme synchronized (Integer/Long)-128——127是同一个对象
                instanceVar = privateVar;
                out.println(instanceVar);
            }
        }
    }

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                new SyncObject().add();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                new SyncObject().add();
            }
        };
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        out.println("two object " + (System.currentTimeMillis() - s));

        long l = System.currentTimeMillis();
        SyncObject so = new SyncObject();
        Thread t3 = new Thread() {
            @Override
            public void run() {
                so.add();
            }
        };
        Thread t4 = new Thread() {
            @Override
            public void run() {
                so.add();
            }
        };
        t3.start();
        t4.start();
        while (t3.isAlive() || t4.isAlive()) {
        }
        out.println("one object " + (System.currentTimeMillis() - l));
    }
}
