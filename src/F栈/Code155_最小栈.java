package F栈;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2021/12/24 10:16
 */
public class Code155_最小栈 {

    Stack<Integer> opStack;
    Stack<Integer> tmpStack;
    int min;


    //构造函数
    public Code155_最小栈() {
        opStack = new Stack<>();
        tmpStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(tmpStack.isEmpty()){
            tmpStack.add(val);
            min = val;
        }else {
            min = min > val ? val : min;
            tmpStack.add(min);
        }
        opStack.add(val);
    }

    public void pop() {
        opStack.pop();
        tmpStack.pop();
        if(tmpStack.isEmpty()){
            min = Integer.MAX_VALUE;
        }else {
            min = tmpStack.peek();
        }
    }

    public int top() {
        return opStack.peek();
    }

    public int getMin() {
        return tmpStack.peek();
    }


}
