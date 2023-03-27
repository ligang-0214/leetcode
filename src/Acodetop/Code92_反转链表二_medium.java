package Acodetop;



/**
 * @author 松鼠
 * @data 2022/2/23 14:05
 */
public class Code92_反转链表二_medium {

    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseBetween(head, 2, 4);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int index = right - left;
        ListNode newHead = new ListNode(-1, head);
        ListNode start = newHead;
        ListNode end = newHead;
        ListNode pre = null;

        for (int i = 0; i < index; i++) {
            end = end.next;
        }
        for (int i = 0; i < left; i++) {
            if(i == left-1){
                pre = start;
            }
            start = start.next;
            end = end.next;
        }
        ListNode endNext = end.next;
        end.next = null;

        pre.next = reverseList(start);
        start.next = endNext;
        return newHead.next;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre= null;
        while (head != null){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        // 最后 cur 和 head 都指向 null
        return pre;
    }

}
