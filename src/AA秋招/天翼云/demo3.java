package AA秋招.天翼云;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/9/14 21:06
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tili = sc.nextInt();
        sc.nextLine();
//        String[] shiyong = sc.nextLine().split(" ");
//        String[] xiaohao = sc.nextLine().split(" ");
        int temp1 = sc.nextInt();
        int[] shiyong = new int[temp1];
        for (int i = 0; i < temp1; i++) {
            shiyong[i] = sc.nextInt();
        }
        int temp2 = sc.nextInt();
        int[] xiaohao = new int[temp2];
        for (int i = 0; i < temp2; i++) {
            xiaohao[i] = sc.nextInt();
        }


//        int furNum = Integer.valueOf(shiyong[0]);
        int[] avail = new int[shiyong.length];
        for (int i = 0; i < shiyong.length; i++) {
            avail[i] = shiyong[i];
        }
        int[] cost = new int[shiyong.length];
        for (int i = 0; i < shiyong.length; i++) {
            cost[i] = xiaohao[i];
        }
        int[][] dp = new int[temp1][tili + 1];
        for (int i = 0; i < temp1; i++) {
            for (int j = 0; j < tili + 1; j++) {
                if (j < cost[0]) {
                    dp[i][j] = 0;
                } else {
                    dp[0][j] = cost[0];
                }

            }
        }

        for (int i = 1; i < temp1; i++) {
            for (int j = 1; j < tili + 1; j++) {
                if (j < cost[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + avail[i]);
                }

            }
        }
        System.out.println(dp[temp1 - 1][tili]);
    }
}
