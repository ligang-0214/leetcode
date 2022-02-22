package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/22 8:49
 */
public class Code122_买卖股票的最佳时机二_medium {
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
}
