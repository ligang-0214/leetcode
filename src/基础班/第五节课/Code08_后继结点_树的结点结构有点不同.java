package 基础班.第五节课;

/**
 * Author:松鼠
 * Date:2021/6/28 20:37
 */
@SuppressWarnings("all")
public class Code08_后继结点_树的结点结构有点不同 {

    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;
        inOrderRecur(head);
        System.out.println();
        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(head,test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(head,test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(head,test).value);

    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 后继结点：中序遍历的情况下，一个节点的后一个结点
     * 分两种情况：
     * 1、p结点有右孩子，那么它的后继节点就是右孩子这棵树的最左边的结点
     * 2、p结点没有右孩子，那么它的后继结点就是。。。。    （不好描述，画个图，比划一下就知道了）
     *
     * @param root
     * @param p
     * @return
     */
    public static Node getSuccessorNode(Node root,Node p){
        if(root == null){
            return null;
        }
        if(p.right != null){
            Node flag = p.right;
            while(flag.left != null){
                flag = flag.left;
            }
            return flag;
        }else {
            Node flag = p.parent;
            while (flag == null || flag.left != p){ //当前结点是其父亲的右孩子的话
                p = flag;
                flag = flag.parent;
            }
            return flag;
        }
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

}
