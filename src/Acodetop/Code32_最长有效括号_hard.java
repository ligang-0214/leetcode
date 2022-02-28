package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/28 10:33
 */
public class Code32_最长有效括号_hard {

    //直接看官方题解  太难了
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    int preMax = i >= 2 ? dp[i - 2] : 0;
                    dp[i] = preMax + 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
