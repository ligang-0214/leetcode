package APractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/10 14:59
 */
public class Code22_括号生成_medium {

    List<String> res = new ArrayList<>();
    StringBuffer temp = new StringBuffer();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        backtracking(n, n);
        return res;
    }

    private void backtracking(int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(temp.toString());
            return;
        }
        if (left > 0) {
            temp.append("(");
            backtracking(left - 1, right);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (right > 0) {
            temp.append(")");
            backtracking(left, right - 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }


}
