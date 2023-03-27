package AInterview.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/12 16:39
 * 小美现在有一个序列，序列中仅包含1和-1两种数字。
 * 小美现在想要知道，有多少个连续的子序列，序列中的数字乘积为正。
 * 输入描述
 * 第一行一个正整数n，表示小美手中的序列长度。
 * 第二行n个空格隔开的数字，每个数字只能是1和-1中的一种。
 * 对于80%的数据保证1 <= n <= 500
 *
 * 对于剩余20%的数据保证1 <= n <= 5000
 *
 * 输出描述
 * 一行一个正整数表示有多少连续的子序列满足题目要求。
 */
public class MeiTuan2 {
    static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] nums = new int[sum];
        sc.nextLine();
        String s = "";
        for (int i = 0; i < 1; i++) {
            s = sc.nextLine();
        }
        String[] split = s.split("\\s+");
        for (int i = 0; i < sum; i++) {
            nums[i] = Integer.valueOf(split[i]);
        }
        process(nums);
        System.out.println(res);
    }

    private static void process(int [] nums) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0){
                ++res;
                dp[i][i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[j] > 0 && dp[i][j-1]){
                    res++;
                    dp[i][j] = true;
                }
                else if(nums[j] < 0 && !dp[i][j-1]){
                    res++;
                    dp[i][j] = true;
                }
            }
        }
    }

}
