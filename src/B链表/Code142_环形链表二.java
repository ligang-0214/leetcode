package B链表;

/**
 * Author:松鼠
 * Date:2021/6/21 10:49
 */
public class Code142_环形链表二 {
    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode listNode = new ListNode(3);
        head.next.next = listNode;
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8,listNode);
        System.out.println(detectCycle(head));
    }


    public static ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null || head.next.next==null){
            return null;
        }
        //使用快慢指针的方式来判断并获取入环结点
        //方法：快指针走两步  慢指针走一步  如果有环的话  他们俩一定会碰头
        //然后让快指针指向开头  快指针和慢指针都一直走一步  当他们俩碰头的时候  就是入环节点
        ListNode fast=head.next.next;
        ListNode slow=head.next;
        while (fast != slow){
            if(fast.next==null || fast.next.next==null){ //此时说明此链表无环
                return null;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        fast=head;
        int flag = 0;
        while (fast != slow){
            flag++;
            fast=fast.next;
            slow=slow.next;
        }
        System.out.println("入环节点的下标位置：" + flag);
        return fast;
    }

}
