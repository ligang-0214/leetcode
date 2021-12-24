package F栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 注意：
 *     你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 *     你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *
 * @author 松鼠
 * @data 2021/12/23 17:30
 */
public class Code225_用队列实现栈 {

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    /**
     * 思路：每次新添加的元素，先扔到辅助队列中，然后看看当前队列中是否有元素，如果有就依次弹出放入备份队列中
     *       然后将当前队列和备份队列内容互换，此时的当前队列顺序其实就是和栈的顺序一样了
     */


    Queue<Integer> inQueue;  //当前队列
    Queue<Integer> outQueue; //辅助队列，作用其实就是备份


    //构造方法
    public Code225_用队列实现栈() {
        inQueue = new LinkedList<>();
        outQueue = new LinkedList<>();
    }

    public void push(int x) {
        outQueue.add(x);
        while (!inQueue.isEmpty()){
            outQueue.add(inQueue.poll());
        }
        Queue<Integer> tmp = new LinkedList<>();
        tmp = outQueue;
        outQueue = inQueue;
        inQueue = tmp;
    }

    public int pop() {
        return inQueue.poll();
    }

    public int top() {
        return inQueue.peek();
    }

    public boolean empty() {
        return inQueue.isEmpty();
    }


}
