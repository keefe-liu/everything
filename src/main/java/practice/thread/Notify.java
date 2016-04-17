package practice.thread;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


/**
 * Created by tingfang.liu on 2016/4/10.
 */
public class Notify {

    private static class MyObject {
        private List<String> list = new ArrayList<>();

        public void addString(String string) {
            for (int i = 0; i < 10; i++) {
                list.add(string);
            }
        }
    }



    public static void main(String[] args) {
        String string = "123";
        out.println(string);
        Integer integer = 3123;
        synchronized (Integer.valueOf(13)) {
            try {
                Integer.valueOf(13).wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
