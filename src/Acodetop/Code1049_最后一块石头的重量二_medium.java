package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/19 14:36
 */
public class Code1049_最后一块石头的重量二_medium {

    //和416很像  问题就是 如何让能发现这是个01背包问题   还是要多做
    public int lastStoneWeightII(int[] stones) {
        if( stones.length < 2){
            return stones[0];
        }

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        //这里不用纠结 sum的奇偶
        // 如果是偶数 那更好  如果是奇数  说明那多出来的一个石头的重量本就不可能撞碎
        int flag = sum / 2;
        int[] dp = new int[flag + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = flag; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j] , dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[flag] - dp[flag];
    }

}
