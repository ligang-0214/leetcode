package practice_MeiTuan;

/**
 * @author 松鼠
 * @data 2022/3/29 21:51
 */
public class Code143_重排链表 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nextNode = slow.next;
        slow.next = null;
        ListNode BHead = reverseLists(nextNode);
        ListNode AHead = head;
        while (AHead != null && BHead != null ){
            ListNode tempA = AHead.next;
            ListNode tempB = BHead.next;
            AHead.next = BHead;
            BHead.next = tempA;
            AHead = tempA;
            BHead = tempB;
        }
    }

    private ListNode reverseLists(ListNode head) {
        ListNode cur = null;
        ListNode pre = null;
        while (head != null){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

}
