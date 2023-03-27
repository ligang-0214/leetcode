package AA秋招.美团;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 10:55
 */
public class demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        int[] dp = new int[m+1];
        for (int i = 1; i <= m; i++) {
            dp[i] = dp[i - 1] + abs1(b[i-1]);
        }
        for (int i = 1; i <= n; i++) {
            int[] temp = new int[m+1];
            temp[0] = dp[0] + abs1(a[i - 1]);
            for (int j = 1; j <= m; j++) {
                if(a[i - 1] != b[j - 1]){
                    temp[j] = Math.min(dp[j - 1] + Math.abs(a[i - 1]  - b[j - 1]) , Math.min(temp[j - 1] + abs1(b[j - 1]) , dp[j] + abs1(a[i - 1])));
                }else {
                    temp[j] = dp[j - 1];
                }
            }
            dp = temp;
        }
        System.out.println(dp[m]);

    }

    private static int abs1(int i) {
        if(i < 0){
            return  -i;
        }
        return i;
    }

}
