package AA秋招.蔚来;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/7/27 19:24
 */
public class WL3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j] = sc.nextInt();
            }
        }
        System.out.println(process(temp));
    }

    public static int process(int[][] grid) {
        int row = grid.length;
        int clo = grid[0].length;

        int[][] dp = new int[row][clo];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < clo; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < clo; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][clo - 1];
    }

}
