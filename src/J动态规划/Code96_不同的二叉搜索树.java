package J动态规划;

/**
 * @author 松鼠
 * @data 2022/1/12 11:28
 */
public class Code96_不同的二叉搜索树 {
    //这题真的是绝了  第一次做的话  绝对死翘翘
    //carl的解析特别好（动规第9题）
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1; // 注意别设置成0了  因为哪怕左/右边没有节点  也相当于是一种可能  所以是1
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j]; //这里为什么是乘 j有n种 i - 1 - j 有m种  组合方式就是n*m
            }
        }
        return dp[n];
    }
}
