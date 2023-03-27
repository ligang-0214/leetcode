package 基础班.第五节课;

import java.util.Stack;

/**
 * Author:松鼠
 * Date:2021/6/27 9:50
 */
@SuppressWarnings("all")
public class Practice_非递归遍历二叉树 {

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
        postOrderUnRecur(head);
    }

    /**
     * 前序遍历
     * @param head
     */
    public static void preOrderUnRecur(Node head){
        System.out.print("pre-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                Node node = stack.pop();
                System.out.print(node.value + " ");
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
            System.out.println();
        }
    }


    /**
     * 中序遍历
     * @param head
     */
    public static void inOrderUnRecur(Node head){
        System.out.print("in-order: ");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    Node node = stack.pop();
                    System.out.print(node.value + " ");
                    head = node.right;
                }
            }
            System.out.println();
        }
    }


    /**
     * 后序遍历
     * @param head
     */
    public static void postOrderUnRecur(Node head){
        System.out.print("post-order: ");
        if (head != null){
            Stack<Node> stack =new Stack<>();
            Stack<Node> res =new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                res.push(head);
                if (head.left != null){
                    stack.push(head.left);
                }
                if (head.right != null){
                    stack.push(head.right);
                }
            }
            while (!res.isEmpty()){
                System.out.print(res.pop().value + " ");
            }
        }
    }

}
