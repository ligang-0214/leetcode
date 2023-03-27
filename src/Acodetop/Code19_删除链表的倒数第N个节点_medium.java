package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/25 10:21
 */
public class Code19_删除链表的倒数第N个节点_medium {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);

        ListNode fast = head;
        ListNode slow = dummy;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

}
