package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/10 18:10
 */
public class Code138_复制带随机指针的链表_medium {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node head=null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        copyRandomList(head);
    }

    //在原本结构上生成新的节点  然后再断开
    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        //插入新的节点
        while (cur != null){
            Node nextNode = cur.next;
            Node newNode = new Node(cur.val);
            cur.next = newNode;
            newNode.next = nextNode;
            cur = nextNode;
        }
        cur = head;
        //开始设置random指针
        while (cur != null){
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        //开始截断新旧节点
        Node resHead = head.next;
        cur = head;
        Node temp = null;
        while (cur != null){
            temp = cur.next;
            cur.next = temp.next;
            temp.next = cur.next != null ? cur.next.next : null;
            cur = cur.next;
        }
        return resHead;
    }

}
