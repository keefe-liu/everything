package exercise;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class PerformanceUtils {

    public static void test(Processer processer) {

        long s = System.currentTimeMillis();
        processer.process();
        long s2 = System.currentTimeMillis();
        if (s2 - s < 10) {
            for (int i = 0; i < 10000; i++) {
                processer.process();
            }
        }
        s = System.currentTimeMillis();
        System.out.println("cost time millis : " + Math.abs(s2 - s));
    }

    public interface Processer {
        void process();
    }
}
