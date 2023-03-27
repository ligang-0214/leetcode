package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/11 9:08
 */
public class Code198_打家劫舍_medium {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length + 1];

        dp[1] = nums[0];
        int res = dp[1];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
            res = Math.max(res , dp[i+1]);
        }
        return res;
    }

}
