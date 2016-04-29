package test;

import java.io.IOException;

/**
 * Created by tingfang.liu on 2016/4/27.
 */
public class IntTest {

    public static void main(String[] args) {
        System.out.println(getInt());
    }

    public static void randomThrowException() throws IOException {
        try {
            Thread.sleep(343);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (System.currentTimeMillis() % 2 == 0) {
            throw new IOException("asdfasd");
        }
    }

    public static int getInt() {
        int a;
        try {
            a = 10;
            randomThrowException();
            return a;
        } catch (IOException e) {
            e.printStackTrace();
            a = 20;
            return a;
        } finally {
            a = 30;

        }
    }
}
