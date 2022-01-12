package J动态规划;

import java.util.Arrays;

/**
 * @author 松鼠
 * @data 2022/1/12 10:09
 */
public class Code343_整数拆分 {
    public static void main(String[] args) {
        integerBreak(15);
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1]; // dp[i]：分拆数字i，可以得到的最大乘积为dp[i]
        dp[1] = 1; //虽然1不可以拆分 但是我为了方便使用 赋值为1
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            int temp = 1;
            for (int j = 1; j <= i / 2; j++) {
                //我这个思路跟carl和官方不太一样
                //我就是认为 max(dp[j], j) 和 max(i - j, dp[i - j]) 相乘 才能得到遍历到j位置时的最大值
                //他们的版本是对的  但就是想不明白  应该需要严格的数学证明
                temp = Math.max(temp, Math.max(dp[j], j) * Math.max(i - j, dp[i - j]));
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}
