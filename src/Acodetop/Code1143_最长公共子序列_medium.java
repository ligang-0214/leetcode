package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/26 11:24
 */
public class Code1143_最长公共子序列_medium {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //第一行和第一列都是0  因为初始化会给默认的值   所以不用显示的初始化为0
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
