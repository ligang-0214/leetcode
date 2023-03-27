package APractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/9 20:35
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
        backtracking(digits, 0, flag);
        return res;
    }

    private void backtracking(String digits, int index, String[] flag) {
        if (index == digits.length()) {
            res.add(temp.toString());
            return;
        }

        int curNum = digits.charAt(index) - '0';
        for (int i = 0; i < flag[curNum].length(); i++) {
            temp.append(flag[curNum].charAt(i));
            backtracking(digits, index + 1, flag);
            temp.deleteCharAt(temp.length() - 1);
        }
    }


}
