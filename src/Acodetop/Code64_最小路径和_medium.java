package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/28 10:24
 */
public class Code64_最小路径和_medium {

    //标准dp的题  咔咔做
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int clo = grid[0].length;

        int[][] dp = new int[row][clo];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < clo; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < clo; j++) {
                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][clo-1];
    }

}
