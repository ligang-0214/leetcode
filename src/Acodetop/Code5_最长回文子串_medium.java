package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/22 14:40
 */
public class Code5_最长回文子串_medium {

    //DP的解法
    //https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
    public String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        int begin = 0;
        int maxLen = 1;

        //len是枚举子串的长度
        for (int len = 2; len <= length; len++) {
            //i是枚举左边界
            for (int i = 0; i < length; i++) {
                //j - i + 1 = len   所以  j = len + i - 1   j是右边界
                //j是右边界
                int j = len + i - 1;
                if (j >= length) { //如果右边越界  就退出循环
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = 0;
                } else {
                    if (j - i < 3) { //举了例子画一下 就明白了
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //更新最长子串
                if (dp[i][j] == 1) {
                    maxLen = Math.max(maxLen, j - i + 1);
                    begin = i;
                }
            }

        }
        return s.substring(begin, begin + maxLen); //包前不包后
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
