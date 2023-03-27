package 基础班.第四节课;

import java.util.Stack;

/**
 * Author:松鼠
 * Date:2021/6/13 15:35
 */
public class Code04_回文链表 {

    public static void main(String[] args) {
        Node head=null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");

    }

    private static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


    /**
     * 定义结点
     */
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    // need n extra space
    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur=cur.next;
        }
        cur = head;
        while (cur!=null){
            if(cur.value!=stack.pop().value)
                return false;
            cur=cur.next;
        }
        return true;
    }

    // need n/2 extra space
    //利用到快慢指针   要好好看看
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        //这个初始化大有讲究  初始化决定了当fast指到最后时  slow指到哪个位置
        Node slow = head.next; //慢指针
        Node fast = head;      //快指针
        //快慢指针的使用
        while (fast.next != null && fast.next.next != null) {//保证下面两条语句的正确
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // need O(1) extra space
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head; //慢指针
        Node n2 = head; //快指针
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null; //use to reverseList
        while (n2 != null) { // right part reverseList
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1; // n3 -> save last node
        n2 = head;// n2 -> left first node
        boolean res = true;
        while (n1 != null && n2 != null) { //开始核对左、右两部分的值
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next; // left to mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

}
