package 基础班.第六节课;

import java.util.HashSet;
import java.util.Stack;

/**
 * Author:松鼠
 * Date:2021/7/5 15:07
 */
@SuppressWarnings("all")
public class Code02_DFS {

    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value); //这里根节点需要先输出一下
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur); //每次把刚弹出来的元素再压回去 就是为了后面用来回溯
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break; //因为是深度遍历  只要在nexts中找到一个还没遍历过的结点就可以结束了
                }
            }
        }
    }


    public static void dfsPractice(Node node){
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> selectedNode = new HashSet<>();
        stack.add(node);
        selectedNode.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            for (Node next : pop.nexts) {
                if(!selectedNode.contains(next)){
                    stack.push(pop);
                    stack.push(next);
                    selectedNode.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
