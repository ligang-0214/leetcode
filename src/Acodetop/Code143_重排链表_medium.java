package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/24 10:05
 */
public class Code143_重排链表_medium {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode newHead = new ListNode(-1, head);
        ListNode fast = newHead;
        ListNode slow = newHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //反转后半段链表
        ListNode headB = reverseLists(slow.next);
        slow.next = null;
        //拼接到一起
        ListNode headA = head;
        while (headB != null) {
            ListNode headANext = headA.next;
            headA.next = headB;
            ListNode headBNext = headB.next;
            headB.next = headANext;
            headA = headANext;
            headB = headBNext;
        }

    }

    public ListNode reverseLists(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;

        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

}
