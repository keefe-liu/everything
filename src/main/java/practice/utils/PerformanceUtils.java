package practice.utils;

import java.util.Random;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class PerformanceUtils {

    public static void test(String task, Processer processer) {

        long s = System.currentTimeMillis();
        long s2 = s;
        long count = 0;
        while (s2 - s < 10000) {
            processer.process();
            s2 = System.currentTimeMillis();
            count++;
        }
        System.out.println(task + " run " + count + " times. avg " + (s2 - s) / count + " mills second");
    }

    public interface Processer {
        void process();
    }

    public static void main(String[] args) {
        PerformanceUtils.test("test task", () -> {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
            }
        });
    }
}
