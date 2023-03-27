package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/1 14:56
 */
public class Code518_零钱兑换二_medium {

    public int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; //这个初值太重要了  要明白为什么   它是基石
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }


}
