package A数组;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 *
 * Author:松鼠
 * Date:2021/9/15 20:24
 */
public class Code26_删除有序数组中的重复项 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,2,2,2,3,};
        System.out.println(removeDuplicatesPractice(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int slow = 0;
        int flag = nums[0];
        for (int fast = 0; fast < nums.length ; fast++) {
            if(nums[fast] != flag){
                flag = nums[fast];
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }

    public static int removeDuplicatesPractice(int[] nums){
        if(nums.length == 0)
            return 0;
        int slow = 0;
        int fast = 1;
        while (fast < nums.length){
            if(nums[slow] == nums[fast]){
                fast++;
            }else {
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }
}
