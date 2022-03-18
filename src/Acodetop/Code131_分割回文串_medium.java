package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/3/18 16:20
 */
public class Code131_分割回文串_medium {

    List<List<String>> res = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int curIndex) {
        if (curIndex == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = curIndex; i < s.length(); i++) {
            if (isPalindrome(s, curIndex, i)) {
                temp.addLast(s.substring(curIndex, i + 1));
            } else {
                continue; //这个continue 挺重要的
            }
            backtracking(s, i + 1);
            temp.removeLast();
        }


    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        while (startIndex < end) {
            if (s.charAt(startIndex) != s.charAt(end))
                return false;
            startIndex++;
            end--;
        }
        return true;
    }

}
