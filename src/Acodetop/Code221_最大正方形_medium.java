package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/10 16:47
 */
public class Code221_最大正方形_medium {

    //https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
    //就离谱  解析太强了   一下点破
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int res = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '0') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    res = Math.max(res, dp[i + 1][j + 1]);
                }
            }
        }
        return res * res;
    }

}
