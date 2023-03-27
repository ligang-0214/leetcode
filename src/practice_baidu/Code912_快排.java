package practice_baidu;

import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/4/10 10:15
 */
public class Code912_快排 {

    public int[] sortArray(int[] nums) {
        if(nums.length < 2){
            return nums;
        }

        quickSort(nums , 0 , nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right){
            swap(nums , left + new Random().nextInt(right - left) , right);
            int[] flag = partition(nums , left , right);
            quickSort(nums , left , flag[0] - 1);
            quickSort(nums , flag[1] + 1 , right);
        }
    }

    private int[] partition(int[] nums, int left, int right) {
        int leftFlag = left - 1;
        int rightFlag = right;
        int cur = left;
        while (cur < rightFlag){
            if(nums[cur] < nums[right]){
                swap(nums , ++leftFlag , cur++);
            }else if(nums[cur] > rightFlag){
                swap(nums , --rightFlag , cur);
            }else {
                cur++;
            }
        }
        swap(nums , right , rightFlag);
        return new int[]{leftFlag + 1 , rightFlag};
    }

    private void swap(int[] nums, int i, int right) {
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
    }

}
