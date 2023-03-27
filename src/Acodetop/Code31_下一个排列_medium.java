package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/26 10:09
 */
public class Code31_下一个排列_medium {

    //这个主要就是思想   不然的话真不行【思路看官方题解】
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i +1]){
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]){
                j--;
            }
            swap(nums , i , j);
        }
        reverse(nums , i +1);
        return;
    }

    private void reverse(int[] nums, int start) {
        int length = nums.length - 1;
        while (start < length){
            swap(nums , start , length);
            start++;
            length--;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
