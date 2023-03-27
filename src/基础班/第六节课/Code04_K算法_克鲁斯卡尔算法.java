package 基础班.第六节课;

import java.util.*;

/**
 * Author:松鼠
 * Date:2021/7/6 10:26
 */
@SuppressWarnings("all")
public class Code04_K算法_克鲁斯卡尔算法 {

    /**
     * 并查集的创建
     *
     * 并查集主要就是两个功能：
     * 一个是查看两个元素是否在一个集合中：
     * 二个是合并两个集合。
     */
    public static class UnionFind {
        private HashMap<Node, Node> fatherMap; //后一个结点是前一个结点的父节点
        private HashMap<Node, Integer> rankMap; //结点于等级的集合 供合并集合的时候使用

        //构造方法
        public UnionFind() {
            fatherMap = new HashMap<Node, Node>();
            rankMap = new HashMap<Node, Integer>();
        }

        private Node findFather(Node n) {
            Node father = fatherMap.get(n);
            if (father != n) {
                father = findFather(father);
            }
            fatherMap.put(n, father); //为什么要加上这一句  感觉有点多余
            return father;
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            rankMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        //a、b是否在相同的set
        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        //a、b的集合 合并起来
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            //这个判断也是多余 因为在合并之前就已经判断是否属于同一集合 简直了。。。。
//            if (aFather != bFather) {
            int aFrank = rankMap.get(aFather);
            int bFrank = rankMap.get(bFather);
            if (aFrank >= bFrank) { //如果a集合的rank大于等于b集合 就把b集合的father挂在a集合的father下
                fatherMap.put(bFather, aFather);
                rankMap.put(aFather, aFrank + bFrank);
            } else {
                fatherMap.put(aFather, bFather);
                rankMap.put(bFather, aFrank + bFrank);
            }
//            }
        }
    }

//    public static class EdgeComparator implements Comparator<Edge> {
//        @Override
//        public int compare(Edge o1, Edge o2) {
//            return o1.weight - o2.weight;
//        }
//    }

    /**
     * 要求是无向图
     * @param graph
     * @return
     */
    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
//        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        //使用lambda表达式来表示   按照边的权重升序排序   小根堆
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(
                (Edge o1, Edge o2) -> {return o1.weight - o2.weight;});
        for (Edge edge : graph.edges) {
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }



}
