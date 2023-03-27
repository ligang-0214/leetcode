package AInterview.wyHuLianWang;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/3/27 15:26
 */
public class hlw2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        System.out.println(n);
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;
        int i = 1;
        while (i < n){
            if(str.charAt(i) == str.charAt(i-1) || str.charAt(i) - 'a' == (str.charAt(i-1) -'a' + 1) || str.charAt(i) -'a' == (str.charAt(i-1) - 'a' - 1)){
                if(i > 1){
                    dp[i] = Math.max(str.charAt(i -1) - 'a' + 1 + str.charAt(i) - 'a' + 1 + dp[i-2] , dp[i-1]);
                }
                else {
                    dp[i] = str.charAt(i -1) - 'a' + str.charAt(i) - 'a' + 2;
                }
            }else {
                dp[i] = dp[i-1];
            }
            res = Math.max(dp[i] , res);
            i++;
        }

        System.out.println(res);
    }
}
