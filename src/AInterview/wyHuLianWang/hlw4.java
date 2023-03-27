package AInterview.wyHuLianWang;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/27 16:40
 */
public class hlw4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        for (int i = 1; i < m; i++) {
            if(nums[0][i] != nums[0][i-1]){
                dp[0][i] = dp[0][i-1] + 2;
            }else {
                dp[0][i] = dp[0][i-1] + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if(nums[i][0] != nums[i-1][0]){
                dp[i][0] = dp[i-1][0] + 2;
            }else {
                dp[i][0] = dp[i-1][0] + 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int up = nums[i][j] == nums[i-1][j] ? 1 : 2;
                int left = nums[i][j] == nums[i][j-1] ? 1 : 2;
                dp[i][j] = Math.min(dp[i-1][j] + up , dp[i][j-1] + left);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
