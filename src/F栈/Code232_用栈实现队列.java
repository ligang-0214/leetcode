package F栈;

import java.util.Stack;

/**
 * 说明：
 *      你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *      你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *      假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 *
 * @author 松鼠
 * @data 2021/12/23 15:42
 */
public class Code232_用栈实现队列 {

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    /**
     * 思路：每次新元素压入队列就直接扔进inStack栈中，当涉及到  弹出/获取队列头元素 时，
     *      就会将inStack中的元素依次弹出并放入outStack中，此时outStack顶部元素就是队列头元素
     */

    Stack<Integer> inStack;
    Stack<Integer> outStack;


    //构造方法
    public Code232_用栈实现队列() {
         inStack = new Stack<Integer>();
         outStack = new Stack<Integer>();
    }

    public void push(int x) {
        inStack.add(x);
    }

    public int pop() {
        //如果outStack不为空的话  就直接弹出  如果为空  那就需要从inStack里重新弄过来一些元素
        if(!outStack.isEmpty())
            return outStack.pop();
        while (!inStack.isEmpty()){
            outStack.add(inStack.pop());
        }
        return outStack.pop();
    }

    public int peek() {
        if(!outStack.isEmpty())
            return outStack.peek();
        while (!inStack.isEmpty()){
            outStack.add(inStack.pop());
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }





}
