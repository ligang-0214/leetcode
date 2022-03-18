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
        if(digits == null || digits.length() == 0){
            return res;
        }
        String[] numString = {
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

        char[] chars = digits.toCharArray();
        backtracking(chars , 0 , numString);
        return res;
    }

    private void backtracking(char[] chars, int cur , String[] numString) {
        if(temp.length() == chars.length){
            res.add(new String(temp));
            return;
        }
        for (int i = 0; i < numString[chars[cur] - '0'].length(); i++) {
            temp.append(numString[chars[cur] - '0'].charAt(i));
            backtracking(chars , cur + 1 , numString);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
