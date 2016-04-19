package practice.algorithm;

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

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int key = array[high];
            int i = low;
            int j = high;
            while (i < j) {
                while (i < j && array[i] <= key) {
                    i++;
                }
                if (i < j) {
                    array[j] = array[i];
                    j--;
                }
                while (i < j && array[j] >= key) {
                    j--;
                }
                if (i < j) {
                    array[i] = array[j];
                    i++;
                }
            }
            array[i] = key;
            if (low < i - 1) {
                quickSort(array, low, i - 1);
            }
            if (i + 1 < high) {
                quickSort(array, i + 1, high);
            }
        }
    }
}
