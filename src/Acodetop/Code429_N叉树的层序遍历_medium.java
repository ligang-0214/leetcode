package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/11 10:08
 */
public class Code429_N叉树的层序遍历_medium {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Node> linkedList = new LinkedList<>();
        if (root == null) {
            return res;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = linkedList.removeFirst();
                temp.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        linkedList.addLast(child);
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
