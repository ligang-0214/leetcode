package 基础班.第四节课;

/**
 * Author:松鼠
 * Date:2021/6/16 10:01
 */
@SuppressWarnings("all")
public class Code07_链表相交 {
    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value); //6

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);  //2

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);  //6

    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 主要逻辑判断方法
     * @param head1
     * @param head2
     * @return
     */
    public static Node getIntersectNode(Node head1, Node head2){
        if(head1==null || head2==null){
            return null;
        }
        //首先判断是否有环
        Node loop1=getLoopNode(head1);
        Node loop2=getLoopNode(head2);
        //情况1：都无环
        if (loop1==null && loop2==null){
            return noLoop(head1,head2);
        }
        //情况2：都有环
        if (loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        //情况3：一个有环  一个无环  两个一定不相交  不然这种情况就不存在
        return null;

    }

    /**
     * 如果两个链表都有环
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1=head1;
        Node cur2=head2;
        if(loop1 == loop2){ //如果入环结点一样的话
            int n=0;
            while (cur1 != loop1){
                n++;
                cur1=cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2=cur2.next;
            }
            cur1= n > 0 ? head1 : head2; //此时cur1指向较长的链表
            cur2 = cur1==head1 ? head2 : head1;
            n = n > 0 ? n : n*(-1);
            while (n > 0){
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;

        }else { //如果入环节点不相同的话
            cur1 = loop1;
            while (loop1 != loop2){
                loop1 = loop1.next;
                if(loop1 == cur1){
                    return null;
                }
            }
            return loop1;
        }
    }

    /**
     * 当两个链表无环的情况下  判断是否有相交结点
     * @param head1
     * @param head2
     * @return  有相交结点则返回  没有则返回空
     */
    private static Node noLoop(Node head1, Node head2) {
        Node cur1=head1;
        Node cur2=head2;
        int n=0;
        while (cur1.next != null){
            n++;
            cur1=cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2=cur2.next;
        }
        if(cur1 != cur2) //如果两个链表最后一个都不相等  那一定不相交
            return null;
        cur1= n > 0 ? head1 : head2; //此时cur1指向较长的链表
        cur2= cur1==head1 ? head2 : head1;
        n= n > 0 ? n : n*(-1);
        while (n > 0){
            cur1=cur1.next;
            n--;
        }
        while (cur1 != cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }

    /**
     * 判断是否有环
     * @param head
     * @return 有环则返回入环结点  无环就返回null
     */
    private static Node getLoopNode(Node head) {
        if (head==null || head.next==null || head.next.next==null){
            return null;
        }
        //使用快慢指针的方式来判断并获取入环结点
        //方法：快指针走两步  慢指针走一步  如果有环的话  他们俩一定会碰头
        //然后让快指针指向开头  快指针和慢指针都一直走一步  当他们俩碰头的时候  就是入环节点
        Node fast=head.next.next;
        Node slow=head.next;
        while (fast != slow){
            if(fast.next==null || fast.next.next==null){ //此时说明此链表无环
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=head;
        while (fast != slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
