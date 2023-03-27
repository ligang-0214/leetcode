package 基础班.第六节课;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Author:松鼠
 * Date:2021/7/6 11:33
 */
@SuppressWarnings("all")
public class Code05_P算法_普利姆算法 {


//    public static class EdgeComparator implements Comparator<Edge> {
//
//        @Override
//        public int compare(Edge o1, Edge o2) {
//            return o1.weight - o2.weight;
//        }
//
//    }

    /**
     * 要求是无向图
     * @param graph
     * @return
     */
    public static Set<Edge> primMST(Graph graph) {
        //存放解锁的边
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
                (Edge o1, Edge o2) -> {return o1.weight - o2.weight;});
        //存放生成树中的结点
        HashSet<Node> set = new HashSet<>();
        //存放最后生成树的边
        Set<Edge> result = new HashSet<>();
        //处理森林时候才有用，因为各个森林是不连通的，为了满足一些题的边界条件
        // 如果告诉这个图是连通的，就不需要这个循环
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge : node.edges) {//把和当前结点相连的边都放进小根堆中
                    priorityQueue.add(edge);
                }

                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to; //可能是新的点
                    if (!set.contains(toNode)) { //如果不在生成树的集合中   就是新的点
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }

            }
        }
        return result;
    }

    // 请保证graph是连通图
    // graph[i][j]表示点i到点j的距离，如果是系统最大值代表无路
    // 返回值是最小连通图的路径之和
    public static int prim(int[][] graph) {
        int size = graph.length;
        int[] distances = new int[size];
        boolean[] visit = new boolean[size];
        visit[0] = true;
        for (int i = 0; i < size; i++) {
            distances[i] = graph[0][i];
        }
        int sum = 0;
        for (int i = 1; i < size; i++) {
            int minPath = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distances[j] < minPath) {
                    minPath = distances[j];
                    minIndex = j;
                }
            }
            if (minIndex == -1) {
                return sum;
            }
            visit[minIndex] = true;
            sum += minPath;
            for (int j = 0; j < size; j++) {
                if (!visit[j] && distances[j] > graph[minIndex][j]) {
                    distances[j] = graph[minIndex][j];
                }
            }
        }
        return sum;
    }

}
