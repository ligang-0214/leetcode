package AA秋招.zoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/10 18:44
 */
public class zoom1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arrs = sc.next().toCharArray();
        int[] dp = new int[n + 1];
        dp[1] = arrs[0] == 'R' ? 1 : -1;
        int[] visited1 = new int[n + 1];
        int[] visited2 = new int[n + 1];
        visited1[1] = -1;
        int[][] res = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            res[i][0] = Math.min(a , b);
            res[i][1] = Math.max(a , b);
        }
        Arrays.sort(res , (o1, o2) -> {return o1[0]- o2[0];});
        int flag = 1;
        while ((flag < n)) {

            for (int i = 0; i < n - 1; i++) {
                if(visited1[res[i][0]] != 0 && visited2[i] != 1){
                    visited2[i] = 1;
//                    visited1[]
                }

            }
        }
    }
}
