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
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int right = 0; right < s.length(); right++) {
            for (int left = 0; left <= right; left++) {
                if(s.charAt(left) == s.charAt(right) && ( right - left <= 2 ||  dp[left + 1][right - 1])){
                    dp[left][right] = true;
                }
            }
        }

//        backtracking1(s, 0);
        backtracking2(s, 0 , dp);
        return res;
    }

    private void backtracking2(String s, int index, boolean[][] dp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(dp[index][i]){
                temp.add(s.substring(index, i + 1));
                backtracking2(s, i + 1 , dp);
                temp.removeLast();
            }
        }
    }

    private void backtracking1(String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isHuiWenString(s, index, i)) {
                temp.add(s.substring(index, i + 1));
            } else {
                continue;
            }
            backtracking1(s, i + 1);
            temp.removeLast();
        }
    }

    private boolean isHuiWenString(String s, int left, int right) {
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
