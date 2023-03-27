package J动态规划;

/**
 * Author:松鼠
 * Date:2021/9/1 21:18
 */
public class Code518_零钱兑换二 {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        System.out.println(change(5, arr));
    }

    /**
     * 暴力递归
     */
    static int res = 0;
    public static int change(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }
        process(coins,amount,0);
        return res;
    }

    private static void process(int[] coins, int amount, int index) {
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res++;
            return;
        }
        if(index == coins.length){
            return;
        }
        for (int i = 0; i*coins[index] <= amount; i++) {
            process(coins,amount - i*coins[index] , index+1);
        }
    }


    public static int change1(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        dp[coins.length][0] = 1; //最后一行其余位置都是0
        for (int index = coins.length-1 ; index >= 0; index--) {
            for (int rest = 0; rest <= amount ; rest++) {
                dp[index][rest] = dp[index+1][rest];
                if(rest-coins[index]>=0){
                    dp[index][rest] += dp[index][rest-coins[index]];
                }
//                for (int i = 0; i*coins[index] <= rest ; i++) {
//                    dp[index][rest] += dp[index+1][rest-i*coins[index]];
//                }
            }
        }
        return dp[0][amount];
    }


    public static int change2(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length ; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }




}
