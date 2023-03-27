package practice_MeiTuan;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/3/30 10:53
 */
public class Code232_用栈实现队列 {

}

class MyQueue {

    Stack<Integer> inPut;
    Stack<Integer> outPut;
    public MyQueue() {
        inPut = new Stack<>();
        outPut = new Stack<>();
    }

    public void push(int x) {
        inPut.push(x);
    }

    public int pop() {
        if(outPut.isEmpty()){
            while (!inPut.isEmpty()){
                outPut.push(inPut.pop());
            }
        }else {
            return outPut.pop();
        }
        return outPut.pop();
    }

    public int peek() {
        if(outPut.isEmpty()){
            while (!inPut.isEmpty()){
                outPut.push(inPut.pop());
            }
        }else {
            return outPut.peek();
        }
        return outPut.peek();
    }

    public boolean empty() {
        return inPut.isEmpty() && outPut.isEmpty();
    }
}
