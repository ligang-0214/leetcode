package H回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2021/12/29 15:34
 */
public class Code17_电话号码的字母组合 {
    public static void main(String[] args) {

    }

    List<String> res = new LinkedList<>();
    StringBuilder temp = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
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
        backtracking(0,digits,numString);
        return res;
    }

    /**
     * @param digitsIndex 指向 digits 中的位置
     * @param digits
     * @param numString
     */
    private void backtracking(int digitsIndex, String digits, String[] numString) {
        if(digitsIndex == digits.length()){
            res.add(temp.toString());
            return;
        }

        String s = numString[digits.charAt(digitsIndex) - '0']; //假设当前digits为233 那第一次进入回溯函数时s为abc
        for (int i = 0; i < s.length(); i++) {
            temp.append(s.charAt(i));
            backtracking(digitsIndex+1,digits,numString); //这里的digitsIndex+1就指向digits下一位
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
