package APractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/9 21:57
 */
public class Code131_分割回文串_medium {

    //https://leetcode.cn/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
    // 可以用 dp 优化判断回文字符串  降低时间复杂度
    // 我好牛  一把过
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();

    public List<List<String>> partition(String s) {
        int length = s.length();
        if (s == null || length == 0) {
            return res;
        }
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j + 1 <= i - 1 && !dp[j + 1][i - 1]) {
                        dp[j][i] = false;
                    } else {
                        dp[j][i] = true;
                    }
                } else {
                    dp[j][i] = false;
                }
            }
        }

        backtracking(s, dp, 0);
        return res;
    }

    private void backtracking(String s, boolean[][] dp, int index) {

        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (dp[index][i]) {
                temp.addLast(s.substring(index, i + 1));
                ;
                backtracking(s, dp, i + 1);
                temp.removeLast();
            } else {
                continue;
            }
        }
    }


}
