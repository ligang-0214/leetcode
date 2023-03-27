package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/21 21:14
 */
public class Code121_买卖股票的最佳时机_easy {

    //贪心解法
    public int maxProfit1(int[] prices) {
        int res = 0;
        int leftMin = Integer.MAX_VALUE;
        for (int price : prices) {
            leftMin = Math.min(leftMin, price);
            res = Math.max(price - leftMin, res);
        }
        return res;
    }


    // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
    // DP解法  时间：O(N)    空间：O(N)
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        // dp[i][j]: 下标为 i 这一天结束的时候，手上持股状态为 j 时，我们持有的现金数，也就是最大利润
        int[][] dp = new int[length][2];
        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[length - 1][0];
    }

    // DP优化解法  时间：O(N)    空间：O(1)
    public int maxProfit3(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }
}
