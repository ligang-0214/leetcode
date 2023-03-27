package 基础班.第七节课;

import java.util.PriorityQueue;

/**
 * Author:松鼠
 * Date:2021/7/19 21:35
 */
public class Code05_IPO {
    public static void main(String[] args) {

    }

    public static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }


    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital){
        //以花费的升序排列
        PriorityQueue<Node> minQueue = new PriorityQueue<>(((o1, o2) -> {return o1.c - o2.c;}));
        //以利润的降序排列
        PriorityQueue<Node> maxQueue = new PriorityQueue<>(((o1, o2) -> {return o2.p - o1.p;}));
        //初始化一下原始数据
        for (int i = 0; i < Profits.length ; i++) {
            minQueue.add(new Node(Profits[i],Capital[i]));
        }
        //把情况捋清楚 然后写条件
        for (int i = 0; i < K ; i++) {
            while (!minQueue.isEmpty() && minQueue.peek().c < W){
                maxQueue.add(minQueue.poll());
            }
            if(maxQueue.isEmpty())
                return W;
            W += maxQueue.poll().p;
        }
        return W;
    }

}
