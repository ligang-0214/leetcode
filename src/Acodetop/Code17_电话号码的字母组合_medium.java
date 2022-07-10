package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/3/18 15:49
 */
public class Code17_电话号码的字母组合_medium {

    List<String> res = new ArrayList<>();
    StringBuffer temp = new StringBuffer();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] flag = new String[]{
                "", //0
                "", //1
                "abc", //2
                "def", //3
                "ghi", //4
                "jkl", //5
                "mno", //6
                "pqrs", //7
                "tuv", //8
                "wxyz" //9
        };

        backtracking(flag, 0, digits);
        return res;
    }

    private void backtracking(String[] flag, int curIndex, String digits) {
        if (temp.length() == digits.length()) {
            res.add(new String(temp));
            return;
        }
        String str = flag[digits.charAt(curIndex) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backtracking(flag, curIndex + 1, digits);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
