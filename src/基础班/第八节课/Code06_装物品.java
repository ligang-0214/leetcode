package 基础班.第八节课;

/**
 * Author:松鼠
 * Date:2021/7/22 14:55
 */
public class Code06_装物品 {
    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(maxValue1(weights, values, bag));
//        System.out.println(maxValue2(weights, values, bag));
    }

    public static int maxValue1(int[] weights, int[] values, int bag) {
        return process1(weights, values, 0, 0,0, bag);
    }

    public static int process1(int[] weights, int[] values, int i,
                               int alreadyWeight, int alreadyValue,int bag) {
        if (alreadyWeight > bag) {
            return 0;
        }
        if (i == weights.length) {
            return alreadyValue;
        }
        int flag1 = process1(weights, values, i + 1, alreadyWeight,alreadyValue, bag);
        int flag2 = process1(weights, values, i + 1, alreadyWeight + weights[i],
                alreadyValue + values[i], bag);

        return Math.max(flag1,flag2);
    }





    public static int maxValue2(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }



}
