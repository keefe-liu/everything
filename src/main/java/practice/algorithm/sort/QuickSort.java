package practice.algorithm.sort;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/11.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {9, 5, 7, 6, 8, 1, 3, 2, 0, 4};
        quickSort(array, 0, array.length - 1);
        out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int key = array[low];
            int i = low;
            int j = high;
            while (i < j) {
                while (i < j && array[j] >= key) {
                    j--;
                }
                if (i < j) {
                    array[i] = array[j];
                    i++;
                }
                while (i < j && array[i] <= key) {
                    i++;
                }
                if (i < j) {
                    array[j] = array[i];
                    j--;
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

    private static void quickSort1(int[] array, int low, int high) {
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

    public void sort(int[] array, int s, int e) {

    }
}
