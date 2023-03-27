package C哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 松鼠
 * @data 2021/12/21 15:25
 */
public class Code18_四数之和 {
    public static void main(String[] args) {

    }


    /**
     * 这个解题思路就是在三数之和的基础上再套一层循环  主体还是使用双指针的思想
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if(i > 0 && nums[i] == nums[i - 1])
                continue;


            for (int j = i+1; j < nums.length; j++) {

                if(j > i+1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = nums.length-1;

                while (right > left){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum > target){
                        right--;
                    }else if(sum < target){
                        left++;
                    }else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //注意：这个right处理一定要在前面  如果遇到left和right以及它们之间的数都一样  会出现数组越界异常
                        while (nums[right] == nums[right - 1] && left < right) right--;
                        while (nums[left] == nums[left + 1] && left < right) left++;

                        right--;
                        left++;
                    }
                }
            }
        }

        return res;
    }

}
