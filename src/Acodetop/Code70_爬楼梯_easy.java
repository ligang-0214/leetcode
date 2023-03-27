package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/24 15:16
 */
public class Code70_爬楼梯_easy {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

}
