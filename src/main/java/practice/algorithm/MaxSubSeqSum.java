package practice.algorithm;

import practice.utils.PerformanceUtils;

/**
 * Created by tingfang.liu on 2016/4/16.
 */
public class MaxSubSeqSum {

    public static void main(String[] args) {

        int[] array = new int[]{5, -23, -412, 46, 9, 65, 34, -540, -35, 1};

        PerformanceUtils.test(() -> MaxSubSeqSum.maxLow(array));
        PerformanceUtils.test(() -> MaxSubSeqSum.maxCrazy(array));
    }

    static int maxLow(int[] array) {

        int tempSum;
        int maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            tempSum = 0;
            for (int j = i; j < array.length; j++) {
                tempSum += array[j];
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                }
            }
        }

        System.out.println("max sum : " + maxSum);
        return maxSum;
    }

    static int maxFast(int[] array) {

        return 0;
    }

    static int maxCrazy(int[] array) {

        int tempSum = 0;
        int maxSum = 0;
        int r = 0;
        int s = 0;
        int e = 0;
        for (int i = 0; i < array.length; i++) {
            tempSum += array[i];
            if (maxSum < tempSum) {
                r = s;
                e = i;
                maxSum = tempSum;
            } else if (tempSum < 0) {
                s = i + 1;
                tempSum = 0;
            }
        }
        System.out.println(r + "  " + e);
        System.out.println("max sum : " + maxSum);
        return maxSum;
    }
}
