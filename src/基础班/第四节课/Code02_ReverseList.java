package 基础班.第四节课;

/**
 * Author:松鼠
 * Date:2021/6/13 14:36
 */
@SuppressWarnings("all")
public class Code02_ReverseList {
    /**
     * 单向链表结点
     */
    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 双向链表结点
     */
    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
    }

    /**
     * 反转单向链表
     * @param head
     * @return
     */
    public static Node reverseList(Node head){
        Node curr=null;
        Node pre=null;
        while (head!=null){
            curr=head.next;
            head.next= pre;
            pre=head;
            head=curr;
        }
        return pre; //返回头指针
    }

    /**
     * 反转双向链表
     * @param head
     * @return
     */
    public static DoubleNode reverseList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode curr = null;
        while (head != null) {
            curr=head.next;
            head.next=pre;
            head.last=curr;
            pre=head;
            head=curr;
        }
        return pre;
    }


}
