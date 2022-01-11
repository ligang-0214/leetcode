package J动态规划;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author 松鼠
 * @data 2022/1/11 15:57
 */
public class Code62_不同路径 {
    int M;
    int N;

    //方法一：暴力递归
    public int uniquePaths1(int m, int n) {
        M = m;
        N = n;
//        int[][] dp = new int[M + 1][N + 1];
        return process1(1, 1);
    }

    private int process1(int m, int n) {
        if (m > M || n > N) {
            return 0;
        }
        if (m == M && n == N) {
            return 1;
        }
        return process1(m + 1, n) + process1(m, n + 1);
    }

    //方法三：跳过第二个阶段（记忆化搜索）  直接优化DP表
    public int uniquePaths3(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];// 多加1 为了方便
        //因为机器人只能向下或者向右走  所以第一行和第一列的每个位置只有一种到达的方式  所以都为1
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }


}
