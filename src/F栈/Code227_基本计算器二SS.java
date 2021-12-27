package F栈;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2021/12/27 9:46
 */
public class Code227_基本计算器二SS {

    public void main(String[] args) {

    }


    /**
     * 12 + 2 * 25
     * 流程：
     *      1、循环读取num为12
     *      2、读到 + ，此时preChar还是初始值 ‘+’ 然后将12扔进栈中  preChar = +   num = 0
     *      3、读取num为2
     *      4、读到 *   此时 preChar 为上一次设置的 +  所以把2扔进栈中
     *      5、循环读取num为25  并且结束了
     *      6、
     * @param s
     * @return
     */
    public int calculate(String s) {
        int res = 0;
        char preChar = '+';
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //处理超过个位数的数字
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0';
            }
            //遇到计算符号  就开始处理这个符号前面的这个数字   然后更新 preChar 的内容
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length()-1){
                switch (preChar){
                    case '+':
                        stack.add(num);break;
                    case '-':
                        stack.add(-num);break;
                    case '*':
                        stack.add(stack.pop() * num);break;
                    default:
                        stack.add(stack.pop() / num);
                }
                num = 0;
                preChar = s.charAt(i);
            }
        }
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
