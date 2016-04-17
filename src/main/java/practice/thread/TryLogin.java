package practice.thread;

/**
 * Created by tingfang.liu on 2016/4/6.
 */
public class TryLogin extends Thread {

    private String u;
    private String p;

    public TryLogin(String u, String p) {
        this.u = u;
        this.p = p;
    }

    @Override
    public void run() {
        try {
            LoginServlet.login(u, p);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
