package APractice;

import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/7/9 16:15
 */
public class Code912_手撕快排_medium {

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums;
        }
        quickSort(nums , 0 , nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left >= right){
            return;
        }
        swap(nums , left + new Random().nextInt(right - left) , right);
        int[] temp =  process(nums , left , right);
        quickSort(nums , left , temp[0] - 1);
        quickSort(nums , temp[1] + 1  , right);
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    private int[] process(int[] nums, int left , int right) {
        int leftIndex = left - 1;
        int rightIndex = right;
        while(left < rightIndex){
            if(nums[left] > nums[right]){
                swap(nums , left , --rightIndex);
            }else if(nums[left] < nums[right]){
                swap(nums , left++ , ++leftIndex);
            }else {
                left++;
            }
        }
        swap(nums , right , left);
        return new int[]{leftIndex + 1 , rightIndex};
    }

}
