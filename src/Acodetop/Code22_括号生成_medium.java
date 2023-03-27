package Acodetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/26 17:52
 */
public class Code22_括号生成_medium {

    //https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
    ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        process("", n, n);
        return res;

    }

    private void process(String s, int leftNum, int rightNum) {
        if (leftNum == 0 && rightNum == 0) {
            res.add(s);
            return;
        }
        if (leftNum > rightNum) {
            return;
        }
        if (leftNum > 0) {
            process(s + "(", leftNum - 1, rightNum);
        }
        if (rightNum > 0) {
            process(s + ")", leftNum, rightNum - 1);
        }
    }

}
