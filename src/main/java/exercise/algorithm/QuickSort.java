package exercise.algorithm;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/11.
 */
public class QuickSort {

    public void sort(int[] array, int s, int e) {

    }

    public static void main(String[] args) {
        int[] array = new int[]{8, 9, 4, 1, 2, 5, 7, 0, 6, 3};
        quickSort(array, 0, array.length - 1);
        out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int s, int e) {
        int temp = array[s];
        int l = s;
        int h = e;
        while (l < h) {
            while (l < h && array[h] >= temp) {
                h--;
            }
            if (l < h) {
                array[l] = array[h];
                l++;
            }
            while (l < h && array[l] <= temp) {
                l++;
            }
            if (l < h) {
                array[h] = array[l];
                h--;
            }
        }
        array[l] = temp;
        if (s < l - 1) {
            quickSort(array, s, l - 1);
        }
        if (l < e - 1) {
            quickSort(array, l + 1, e);
        }
    }
}
