package APractice;

/**
 * @author 松鼠
 * @data 2022/7/30 10:49
 */
public class Code5_最长回文子串_medium {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int left = 0;
        int right = 0;

        for (int col = 1; col < len; col++) {
            for (int row = 0; row <= col; row++) {
                if (s.charAt(row) == s.charAt(col) && (col - row <= 2 || dp[row + 1][col - 1] == 1)) {
                    dp[row][col] = 1;
                    if (col - row > right - left) {
                        left = row;
                        right = col;
                    }
                } else {
                    dp[row][col] = 0;
                }
            }
        }
        return s.substring(left, right + 1);
    }

}
