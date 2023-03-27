package J动态规划;

/**
 * Author:松鼠
 * Date:2021/9/1 14:54
 */
public class Code322_零钱兑换 {
    //和左神暴力递归课上的CoinMin是同一题

    public static void main(String[] args) {
        int[] arr1 = {1,2,5};
        System.out.println(coinChange1(arr1, 5));
    }

    /**
     * 暴力递归的方式  但是提交严重超时了
     */
    static int res = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        process(coins, 0, amount);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void process(int[] arr, int index, int aim) {
        if(aim < 0){
            return ;
        }
        if(aim == 0){
            res = Math.min(res,index);
        }

        for(int j = 0 ; j < arr.length ; j++){
            process(arr,index+1,aim-arr[j]);
        }

    }


    public static int coinChange1(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        int[] memo = new int[amount+1];

        return findWay(coins,amount,memo);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public static int findWay(int[] coins, int amount, int[] memo){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的值  可能为-1  也可能为一个最优解
        if(memo[amount] != 0){
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = findWay(coins,amount-coins[i],memo);
            if(res >= 0 && res < min){
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount];
    }



    public static int coinChange2(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        int[] res = new int[amount+1];
        res[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0 && res[i - coins[j]] < min){
                    min = res[i - coins[j]] + 1;
                }
            }
            res[i] = min;
        }

        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
    }

}
