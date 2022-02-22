package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/21 21:14
 */
public class Code121_买卖股票的最佳时机_easy {

    public int maxProfit(int[] prices) {
        int prePrices = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] < prePrices){
                prePrices = prices[i];
            }else {
                res = Math.max(prices[i] - prePrices , res);
            }
        }
        return res;
    }
}
