package J动态规划;

/**
 * @author 松鼠
 * @data 2022/3/19 15:06
 */
public class Code494_目标和 {
    //回溯也能做  但是不好
    //然后就用dp做  看随想录解析有个简单数学推导转化成dp的过程
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 != 0)
            return 0;
        int size = (target + sum) / 2;
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1; //这个赋初值很重要
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }


}
