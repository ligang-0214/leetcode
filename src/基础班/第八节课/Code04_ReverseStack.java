package 基础班.第八节课;

import java.util.Stack;

/**
 * 不能申请额外的数据结构，只能使用递归函数  逆序一个栈
 * Author:松鼠
 * Date:2021/7/21 16:57
 */
public class Code04_ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack =new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }

    /**
     * reverse方法用来获取每次栈底的元素 放在last中
     * 直到栈为空的时候  就可以分别把每个元素压入栈中
     * @param stack
     */
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        int last = getLastAndRemoveLast(stack);
        reverse(stack);
        stack.push(last);
    }

    /**
     * 找到并且移除栈底的元素
     * @param stack
     * @return
     */
    private static int getLastAndRemoveLast(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if(stack.isEmpty())
            return pop;
        else {
            int last = getLastAndRemoveLast(stack);
            stack.push(pop);
            return last;
        }
    }

}
