package practice_MeiTuan;

/**
 * @author 松鼠
 * @data 2022/3/29 20:08
 */
public class Code92_反转链表二 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        int temp = right - left;
        while (temp-- > 0) {
            fast = fast.next;
        }
        fast = fast.next;
        left--;
        while (left-- > 0) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = fast.next;
        fast.next = null;
        ListNode end = slow.next;
        slow.next = reverseList(slow.next);
        end.next = next;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

}
