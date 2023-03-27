package 基础班.第四节课;

import java.util.HashMap;

/**
 * Author:松鼠
 * Date:2021/6/15 15:49
 */
@SuppressWarnings("all")
public class Code06_复制带有随机指针的链表 {

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithHashMap(head);
//        printRandLinkedList(res1);
        res2 = copyListWithOutHashMap(head);
        printRandLinkedList(res2);
//        printRandLinkedList(head);
    }

    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 使用HashMap来实现   空间复杂度为 O（N）
     * @param head
     * @return
     */
    public static Node copyListWithHashMap(Node head){
        if(head==null){
            return head;
        }

        Node cur=head;
        HashMap<Node,Node> map = new HashMap<>();//用来生成新、老Node的映射
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).rand=map.get(cur.rand);
            map.get(cur).next=map.get(cur.next);
            cur=cur.next;
        }
        return map.get(head);
    }


    /**
     * 不使用HashMap  利用设计的结构实现
     * @param head
     * @return
     */
    public static Node copyListWithOutHashMap(Node head){
        if (head == null){
            return head;
        }
        Node cur=head;
        while(cur != null){ //生成新节点  并插入到原链表中
            Node newNode=new Node(cur.value);
            newNode.next=cur.next;
            cur.next=newNode;
            cur=cur.next.next;
        }
        cur=head;
        while (cur != null){ //设置rand
            cur.next.rand=cur.rand == null ? null : cur.rand.next;
            cur=cur.next.next;
        }
        Node result = head.next; //标记复制后的开头
        cur=head;
        Node flag=null;
        while (cur != null){ //把复制的内容取出来  然后把原链表恢复原样
            flag=cur.next;
            cur.next=flag.next;
            flag.next=cur.next != null ? cur.next.next : null;
            cur=cur.next;
        }
        return result;
    }







    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}
