package Acodetop;


import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/7/11 10:20
 */
public class Code116_填充每个节点的下一个右侧节点指针_medium {

    public Node1 connect(Node1 root) {
        LinkedList<Node1> linkedList = new LinkedList<>();
        if (root == null) {
            return root;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                Node1 node = linkedList.removeFirst();
                if(i == size - 1){
                    node.next = null;
                }else {
                    node.next = linkedList.getFirst();
                }


                if (node.left != null) {
                    linkedList.addLast(node.left);
                }
                if (node.right != null) {
                    linkedList.addLast(node.right);
                }
            }
        }
        return root;
    }

}

class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {
    }

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

}