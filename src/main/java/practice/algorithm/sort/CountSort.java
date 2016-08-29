package practice.algorithm.sort;

import java.util.Arrays;

/**
 * Created by tingfang.liu on 2016/8/29.
 */
public class CountSort {
    public static void main(String[] args) {
        //        int[] nums = {9, 6, 8, 4, 7, 1, 9, 2, 1, 0, 2, 3, 3, 5, 6};
        int[] nums = {9, 0, 8, 7, 6, 5, 1, 2, 3, 4};
        System.out.println(Arrays.toString(sort(nums, 9)));
    }

    public static int[] sort(int[] nums, int max) {
        int[] temp = new int[max + 1];
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        for (int i = 1; i < max + 1; i++) {
            temp[i] += temp[i - 1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            output[--temp[nums[i]]] = nums[i];
            //            temp[nums[i]] = temp[nums[i]] - 1;
        }
        return output;
    }
}
