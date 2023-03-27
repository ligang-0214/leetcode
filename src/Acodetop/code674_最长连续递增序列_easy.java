package Acodetop;

import java.util.Arrays;

/**
 * @author 松鼠
 * @data 2022/7/30 16:43
 */
public class code674_最长连续递增序列_easy {

    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }

        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }

}
