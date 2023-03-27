package practice_baidu;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/4/10 10:25
 */
public class Code215_数组中的第K个最大元素 {

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i >= k) {
                queue.poll();
            }
        }
        return queue.peek();
    }


    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        int[] flag = partition(nums, left, right);
        if (flag[0] <= k && k <= flag[1]) {
            return nums[k];
        } else if (k < flag[0]) {
            return quickSort(nums, left, flag[0] - 1, k);
        } else {
            return quickSort(nums, flag[1] + 1, right, k);
        }
    }

    private int[] partition(int[] nums, int left, int right) {
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

    private void swap(int[] nums, int i, int right) {
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
    }


}
