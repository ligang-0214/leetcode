package F栈;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2021/12/27 19:31
 */
public class Code224_基本计算器SS {
    public void main(String[] args) {

    }

    /**
     * 解法一：这个方法是相当于展开表达式中所有的括号，则得到的新表达式中，
     * 数字本身不会发生变化，只是每个数字前面的符号会发生变化。
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> ops = new Stack<>();

        ops.push(1);
        int sign = 1;

        int res = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
        }

        return  res;
    }


    /**
     * 解法二：最直观的解法，遇到 '(' 就把res和sign扔进栈中，然后一直处理到接下来第一次遇到 ')'
     * @param s
     * @return
     */
    public int calculate2(String s){
        Stack<Integer> stack = new Stack<>();
        // 初始化sing和res：sign 代表正负
        int sign = 1, res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1)))
                    cur = cur * 10 + s.charAt(++i) - '0';
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res); //把前面算的res扔进栈中暂时保存
                res = 0; //置0  为了处理括号里的表达式值
                stack.push(sign); //把括号前的符号也扔进栈中
                sign = 1; //置1  重新初始化
            } else if (ch == ')') {
                //第一个弹出来的是符号  第二个弹出来的是括号内算的值
                res = stack.pop() * res + stack.pop();
            }
            //最后这里相当于处理了空格符
        }
        return res;
    }
}
