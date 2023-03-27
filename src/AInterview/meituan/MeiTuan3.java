package AInterview.meituan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/12 17:23
 * 第一行两个正整数n, m
 * n表明有多少顾客前来点菜，m表示小美现在能做的菜的编号范围在[1, m]。
 * 接下来n行，每行两个数字，表明一名顾客的所点的两道菜的编号。
 * 其中80%的数据保证2 <= n <= 10, 2 <= m <= 20
 * 另外20%的数据保证2 <= n <= 20, 2 <= m <= 40
 */
public class MeiTuan3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(1 << 3);
        int n = sc.nextInt();
        int m = sc.nextInt();
//        int[][] nums = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//        }
        int[][] nums = {
                {1, 2},
                {2,3},
                {3,4}
        };

        boolean[] visited = new boolean[m + 1];
        Arrays.fill(visited, false);
        int res = fun(nums, n - 1, visited);
        System.out.println(res);
    }

    public static int fun(int[][] nums, int i, boolean[] used) {
        if (i < 0) {
            return 0;
        }
        // 不满足当前顾客
        int res = fun(nums, i - 1, used);
        // 满足当前顾客
        int[] customer = nums[i];
        if (!used[customer[0]] && !used[customer[1]]) {
            used[customer[0]] = true;
            used[customer[1]] = true;
            res = Math.max(res, fun(nums, i - 1, used) + 1);
            used[customer[0]] = false;
            used[customer[1]] = false;
        }
        return res;
    }
}
