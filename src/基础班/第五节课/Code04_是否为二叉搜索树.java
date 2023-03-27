package 基础班.第五节课;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author:松鼠
 * Date:2021/6/27 10:31
 */
@SuppressWarnings("all")
public class Code04_是否为二叉搜索树 {

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
        Node head1 = new Node(0);
//        System.out.println(isBST1(head));
        System.out.println(isBST1(head1));
    }


    /**
     * 利用递归的中序遍历来解决
     * 这个方法不太行，如果只有一个数，且为-2147483648怎么办  还是会输出false
     * @param head
     * @return
     */
    static long preValue1 = Long.MIN_VALUE;
    public static boolean isBST1(Node head){
        if (head == null) {
            return true;
        }
        boolean bst1 = isBST1(head.left);
        if (bst1 != true){
            return false;
        }
        if (head.value <= preValue1){
            return false;
        }else {
            preValue1 = head.value;
        }
        return isBST1(head.right);
    }

    /**
     * 利用非递归的中序遍历来解决
     * 这个也不行  这些的是什么垃圾
     * @param head
     * @return
     */
    static long preValue2 = Long.MIN_VALUE;
    public static boolean isBST2(Node head){
        if (head == null) {
            return true;
        }
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value <= preValue2){
                    return false;
                }else {
                    preValue2 = head.value;
                }
                head = head.right;
            }
        }
        return true;
    }


    /**
     * 最笨的方式：
     * 先中序遍历，把内容存起来，再判断是否为递增序列，
     * 这样空间复杂度比较高
     * @param head
     * @return
     */
    public static boolean isBST3(Node head){
        if (head == null) {
            return true;
        }
        ArrayList<Node> list = new ArrayList<>();
        process(head,list);
        int preValue = Integer.MIN_VALUE;
        for (Node cur: list) {
            if (cur.value > preValue){
                preValue = cur.value;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void process(Node node, ArrayList<Node> inOrderList) {
        if (node == null) {
            return;
        }
        process(node.left, inOrderList);
        inOrderList.add(node);
        process(node.right, inOrderList);
    }

}
