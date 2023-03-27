package A数组;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/9/15 21:09
 */
public class Code80_删除有序数组中的重复项二 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};
        int[] arr1 = {0,1};
        System.out.println(removeDuplicates1(arr));
        System.out.println(Arrays.toString(arr));


    }

    public static int removeDuplicates1(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int slow = 0;
        int flag = 1;
        for (int fast = 1; fast < nums.length ; fast++) {
            if(nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
                flag = 1;
            }else if(flag >= 2){
                continue;
            }else {
                flag++;
                nums[++slow] = nums[fast];
            }
        }
        return slow+1;
    }

    public static int removeDuplicates2(int[] nums){
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


}
