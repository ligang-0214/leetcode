package I贪心算法;

/**
 * @author 松鼠
 * @data 2022/1/6 17:13
 */
public class Code122_买卖股票的最佳时机二_贪心和DP {

    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if( temp > 0){
                res += temp;
            }
        }
        return res;
    }

}
