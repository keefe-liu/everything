package practice.algorithm;

/**
 * Created by tingfang.liu on 2016/4/15.
 */
public class RecursivePrint {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            calculateLow(1000);
        }
        long s1 = System.currentTimeMillis();

        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            calculateFast(1000);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(s1 - s);
        System.out.println(l1 - l);
    }

    static void printN(int n) {
        if (n > 0) {
            printN(n - 1);
            System.out.println(n);
        }
    }

    static void calculateLow(int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            result += i * Math.pow(1.1, i);
        }
        System.out.println(result);
    }

    static void calculateFast(int n) {
        double result = 0;
        for (int i = n - 1; i >= 0; i--) {
            result = result * 1.1 + i - 1;
        }
        System.out.println(result);

    }
}
