package H回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/1/5 16:55
 */
public class Code22_括号生成 {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        // 执行深度优先遍历，搜索可能的结果
        backtracking("", n, n);
        return result;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     */
    private void backtracking(String curStr, int left, int right) {
        if(left == 0 && right == 0){
            result.add(curStr); //因为字符串拼接  每次都生成新的对象  所以可以直接仍进结果集
            return;
        }

        if(left > right){
            return;
        }
        //left - 1/right - 1，千万不能写成 --left和--right，因为回栈的时候，这个数值变了，就会影响结果
        if(left > 0){
            backtracking(curStr + "(" , left-1 , right);
        }

        if(right > 0){
            backtracking(curStr + ")" , left , right-1);
        }
    }

}
