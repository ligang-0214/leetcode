package C哈希表;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组
 * @author 松鼠
 * @data 2021/12/21 10:06
 */
public class Code15_三数之和SS {
    public static void main(String[] args) {

    }

    /**
     * 随想录有用哈希法来解决  但是这题是用了双指针的思路
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3 )
            return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { //如果第一个数就大于0  就不可能有符合的结果
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {// nums[i] 相当于a  这里去除a的重复
                continue;
            }

            int left = i + 1; //nums[left] 相当于b
            int right = nums.length - 1; //nums[right] 相当于c
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {//如果和大于0  说明右边的数应该减小一些
                    right--;
                } else if (sum < 0) { //如果和小于0  说明左边的数应该增加一些
                    left++;
                } else {
                    //如果等于0   那就是一种结果
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去除 b、c的重复
                    //注意：这个right处理一定要在前面  如果遇到left和right以及它们之间的数都一样  会出现数组越界异常
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    //左右分别往中间靠  直到两个相遇
                    right--;
                    left++;
                }
            }
        }
        return result;
    }


}
