package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/23 14:24
 */
public class Code142_环形链表二_medium {

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }

        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != slow){
            if(fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
