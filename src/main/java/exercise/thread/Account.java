package exercise.thread;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/10.
 */
public class Account {
    private Integer balance = 50000;
    private final Object lock = new Object();

    public Account() {
    }

    public Account(Integer balance) {
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void transferTo(Account account, Integer money) {
        this.balance -= money;
        int after = account.getBalance() + money;
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.setBalance(after);
    }

    public void in(int money) {
        synchronized (lock) {
            this.balance += money;
            lock.notify();
        }
    }

    public void out(int money) {
        synchronized (lock) {
            if (money > this.balance) {
                out.println("wait for notify");
                try {
                    Thread.sleep(10);
                    lock.wait();
                    out.println("receive notify");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.balance -= money;
        }
    }

    private static class Service {
        private final Object lock = new Object();

        public void service() {
            synchronized (lock) {
                out.println("service start");
                try {
                    lock.wait(900);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                out.println("service end");
            }
        }

        public void notifyOne() {
            synchronized (lock) {
                lock.notify();
                out.println("notify one ");
            }
        }

        public void notifyAllLock() {
            synchronized (lock) {
                lock.notifyAll();
                out.println("notify all ");
            }
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        Thread thread1 = new Thread(() -> service.service());
        Thread thread2 = new Thread(() -> service.service());
        Thread thread3 = new Thread(() -> service.service());
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread notifyThread = new Thread(() -> service.notifyAllLock());
        notifyThread.start();
    }
}
