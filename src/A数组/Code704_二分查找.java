package A数组;

import java.util.Scanner;

/**
 * Author:松鼠
 * Date:2021/9/15 16:43
 */
public class Code704_二分查找 {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr,9));

    }

    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while (left <= right){
            int mid = (right-left)/2 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
