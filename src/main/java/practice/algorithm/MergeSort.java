package practice.algorithm;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/13.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{8, 9, 4, 1, 5, 7, 3, 2, 6, 0, 10, -1};
        mergeSort(array, 0, array.length - 1);
        out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int index = 0;
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                temp[index++] = array[i++];
            } else {
                temp[index++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= high) {
            temp[index++] = array[j++];
        }
        while (index > 0) {
            array[high--] = temp[--index];
        }
    }

    public static void merge1(int[] array, int low, int mid, int high) {
        //FIXME this doesn't work
        // TODO: 2016/4/14 fix it
        int[] temp = new int[high - low + 1];
        System.arraycopy(array, low, temp, 0, high - low + 1);
        int i = 0;
        int j = mid - low + 1;
        int k = 0;
        while (i < mid - low + 1 && j <= high - mid) {
            if (temp[i] < temp[j]) {
                array[low + k] = temp[i++];
                k++;
            } else {
                array[low + k] = temp[j++];
                k++;
            }
        }
        while (i < mid - low + 1) {
            array[low + k] = temp[i++];
            k++;
        }
        while (j < high - mid) {
            array[low + k] = temp[j++];
            k++;
        }
    }
}
