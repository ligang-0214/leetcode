package Acodetop;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/2/24 9:45
 */
public class Code232_用栈实现队列_easy {

    /**
     * 思路：每次新元素压入队列就直接扔进inStack栈中，当涉及到  弹出/获取队列头元素 时，
     *      就会将inStack中的元素依次弹出并放入outStack中，此时outStack顶部元素就是队列头元素
     */

    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public void MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(!outStack.isEmpty()){
            return outStack.pop();
        }
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }

    public int peek() {
        if(!outStack.isEmpty()){
            return outStack.peek();
        }
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}
