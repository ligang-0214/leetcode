package APractice;

/**
 * @author 松鼠
 * @data 2022/7/26 16:14
 */
public class Code123_买卖股票的最佳时机三_hard {

    //代码随想录的解法
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length == 0){
            return 0;
        }
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[0] = 0;
            dp[1] = Math.max(dp[0] - prices[i], dp[1]);
            dp[2] = Math.max(dp[1] + prices[i], dp[2]);
            dp[3] = Math.max(dp[2] - prices[i], dp[3]);
            dp[4] = Math.max(dp[3] + prices[i], dp[4]);
        }
        return dp[4];

    }

}
