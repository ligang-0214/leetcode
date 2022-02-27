package Acodetop;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/2/27 15:56
 */
public class Code155_最小栈_easy {

    Stack<Integer> operateStack;
    Stack<Integer> minStack;
    int min;
    public void MinStack() {
        operateStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        min = Math.min(min , val);
        minStack.push(min);
        operateStack.push(val);
    }

    public void pop() {
        operateStack.pop();
        minStack.pop();
        if(minStack.isEmpty()){
            min = Integer.MAX_VALUE;
        }else {
            min = minStack.peek();
        }
    }

    public int top() {
        return operateStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
