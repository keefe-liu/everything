package exercise.thread;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/6.
 */
public class LoginServlet {

    private static String usernameR;
    private static String passwordR;

    public static synchronized void login(String username, String password) throws InterruptedException {
        usernameR = username;
        Thread.sleep(2000);
        passwordR = password;
        out.println(usernameR + " " + passwordR);
    }

    public static void main(String[] args) {
        Double valueFrom = 1.0;

        out.println(-valueFrom);
    }
}
