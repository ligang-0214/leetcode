package Acodetop;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/2/21 15:33
 */
public class Code912_手撕快排_medium {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 6, 4, 7, 8, 3, 9, 4};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            swap(nums, l + new Random().nextInt(r - l), r);
            int[] leftAndRightIndex = partition(nums, l, r);
            quickSort(nums, l, leftAndRightIndex[0] - 1);
            quickSort(nums, leftAndRightIndex[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int lFlag = l - 1;
        int rFlag = r;
        while (l < rFlag) {
            if (arr[l] < arr[r]) {
                swap(arr, ++lFlag, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --rFlag);
            } else {
                l++;
            }
        }
        swap(arr, rFlag, r);
        return new int[]{lFlag + 1, rFlag};
    }


    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
