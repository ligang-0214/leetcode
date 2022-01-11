package J动态规划;

/**
 * @author 松鼠
 * @data 2022/1/11 15:05
 */
public class Code746_使用最小花费爬楼梯 {
    //这个其实也能优化成只有两个临时变量的版本  但是没必要 重点不在这上面
    public int minCostClimbingStairs(int[] cost) {
        // dp[i]的定义：到达第i个台阶所花费的最少体力为dp[i]
        int[] dp = new int[cost.length];
        //初始化一些已知信息
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //因为到最后的话  不知道是倒数第一个还是倒数第二个更小  所以还需要判断一下
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
