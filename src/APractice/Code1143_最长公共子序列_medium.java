package APractice;

/**
 * @author 松鼠
 * @data 2022/7/30 17:18
 */
public class Code1143_最长公共子序列_medium {

    public int longestCommonSubsequence1(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    //如果需要输出路径的话
    public static int longestCommonSubsequence2(String text1, String text2) {
        StringBuffer stringBuffer = new StringBuffer();

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 从右下角往左上角遍历
        int row = text1.length();
        int col = text2.length();
        while (row >= 1 && col >= 1) {
            if (dp[row][col] > dp[row - 1][col] && dp[row][col] > dp[row][col - 1]) {
                stringBuffer.append(text1.charAt(row - 1));
                row--;
                col--;
            }else if(dp[row][col] == dp[row - 1][col]){
                row--;
            }else if(dp[row][col] == dp[row][col - 1]){
                col--;
            }
        }
        System.out.println(stringBuffer.reverse().toString());
        return dp[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence2("acce", "abcdce"));
    }

}
