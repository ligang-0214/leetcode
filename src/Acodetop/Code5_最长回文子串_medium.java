package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/22 14:40
 */
public class Code5_最长回文子串_medium {

    //DP的解法  下面是我自己的解法   连接中是另外的一种   我觉得还是我这种好理解
    //https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
    public String longestPalindrome1(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        int left = 0;
        int right = 0;
        for (int col = 1; col < length; col++) {
            for (int row = 0; row < col; row++) {
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

    //中心扩展算法【这种才是正常思路】
    public String longestPalindrome2(String s){
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2; //这里的 start 和 end 需要思考一下
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
