package A数组;

import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/9/16 10:40
 */
public class Code977_有序数组的平方 {
    public static void main(String[] args) {
        int[] arr ={-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int resFlag = nums.length-1;
        while (left <= right){
            int l = nums[left]*nums[left];
            int r = nums[right]*nums[right];
            if(l <= r){
                res[resFlag--] = r;
                right--;
            }else {
                res[resFlag--] = l;
                left++;
            }
        }
        return res;
    }

}
