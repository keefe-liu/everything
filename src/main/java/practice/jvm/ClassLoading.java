package practice.jvm;

import java.util.Random;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/24.
 */
public class ClassLoading {
    public static void main(String[] args) {
        out.println(SuperClass.findKthLargest(new int[]{1, 3, 5, 2, 4}, 3));

    }

}

class SuperClass {
    static {
        out.println("super static block");
    }

    private static int partition(int[] nums, int p, int r) {
        int x = nums[r];
        int i = p - 1;
        int temp;
        for (int j = p; j < r; j++) {
            if (nums[j] <= x) {
                i++;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        temp = nums[i + 1];
        nums[i + 1] = nums[r];
        nums[r] = temp;
        return i + 1;
    }

    private static int randomPartition(int[] nums, int p, int r) {
        Random rand = new Random();
        int i = rand.nextInt(r - p) + p;
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
        return partition(nums, p, r);
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int p = 0, r = len - 1, re = 0;
        while (p < r) {
            re = randomPartition(nums, p, r);
            if (len - re == k) {
                return nums[re];
            } else if (len - re < k) {
                r = re - 1;
            } else {
                p = re + 1;
            }
        }
        return nums[r];
    }


    public static int value = 999;
}

class SubClass extends SuperClass {
    static {
        out.println("sub static block");
    }

    public static int value = 123;
}
