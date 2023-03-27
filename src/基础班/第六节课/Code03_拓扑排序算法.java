package 基础班.第六节课;

import java.util.*;

/**
 * Author:松鼠
 * Date:2021/7/6 9:29
 */
@SuppressWarnings("all")
public class Code03_拓扑排序算法 {


    /**
     * 输出的序列应该是不唯一的
     * 适用范围：要求有向图，且有入度为0的节点，且没有环
     * @param graph
     * @return
     */
    public static List<Node> sortedTopology(Graph graph) {
        //key：某个节点  value：结点剩余的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        //入度为0的结点才能进队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node); //找到入度为0的结点，放进队列（至少一个节点）
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);//减1之后，有些节点就是入度为0了
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
