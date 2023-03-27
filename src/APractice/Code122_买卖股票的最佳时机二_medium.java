package APractice;

/**
 * @author 松鼠
 * @data 2022/7/23 17:00
 */
public class Code122_买卖股票的最佳时机二_medium {

    //贪心算法
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int res = 0;
        int prePrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prePrice < prices[i]){
                res += prices[i] - prePrice;
            }
            prePrice = prices[i];
        }
        return res;
    }



    /**
     * dp 的解法
     * @param prices
     * @return
     */
    // https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (prices == null || length < 2) {
            return 0;
        }
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }


    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (prices == null || length < 2) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        // 注意这里为什么需要两个变量  因为 dp[1] 计算的时候需要 dp[0]   所以需要记录
        // 但事实上这题有点怪  就是不要这两个变量也行  完全不影响通过
        int temp1 = dp[0];
        int temp2 = dp[1];
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(temp1, temp2 + prices[i]);
            dp[1] = Math.max(temp2, temp1 - prices[i]);
            temp1 = dp[0];
            temp2 = dp[1];
        }
        return dp[0];
    }

}
