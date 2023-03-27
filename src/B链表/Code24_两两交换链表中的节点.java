package B链表;

/**
 * Author:松鼠
 * Date:2021/6/21 9:55
 */
public class Code24_两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        PrintList.print(head);
        PrintList.print(swapPairs1(head));
//        PrintList.print(swapPairsPractice(head));
    }

    public static ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1 , head);
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            ListNode newHead = cur.next;
            ListNode nextHead = newHead.next;
            pre.next = newHead;
            newHead.next = cur;
            cur.next = nextHead;
            pre = cur;
            cur = nextHead;
        }
        return dummy.next;

    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    //这写的是个什么东西
    public static ListNode swapPairsPractice(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(-1,head);
        ListNode cur = newHead;
        ListNode fast = head.next;
        ListNode pre = head;
        while (true){
            cur.next = fast;
            pre.next = fast.next;
            fast.next = pre;
            cur = pre;
            if(pre.next == null)
                break;
            pre = pre.next;
            if(pre.next == null)
                break;
            fast = pre.next;
        }
        return newHead.next;
    }
}
