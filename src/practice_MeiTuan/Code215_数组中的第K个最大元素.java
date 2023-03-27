package practice_MeiTuan;

import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/3/29 15:48
 */
public class Code215_数组中的第K个最大元素 {

    //如果不允许用优先级队列  就用快排
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);

    }

    private int quickSort(int[] nums, int left, int right, int index) {
        int[] flag = process(nums, left, right);
        if (flag[0] <= index && index <= flag[1]) {
            return nums[index];
        } else if (index > flag[1]) {
            return quickSort(nums, flag[1] + 1, right, index);
        } else {
            return quickSort(nums, left, flag[0] - 1, index);
        }
    }

    private int[] process(int[] nums, int left, int right) {
        if (left < right) {
            swap(nums, left + new Random().nextInt(right - left), right);
        }
        int leftFlag = left - 1;
        int rightFlag = right;
        int cur = left;
        while (cur < rightFlag) {
            if (nums[cur] < nums[right]) {
                swap(nums, ++leftFlag, cur++);
            } else if (nums[cur] > nums[right]) {
                swap(nums, --rightFlag, cur);
            } else {
                cur++;
            }
        }
        swap(nums, rightFlag, right);
        return new int[]{leftFlag + 1, rightFlag};
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
