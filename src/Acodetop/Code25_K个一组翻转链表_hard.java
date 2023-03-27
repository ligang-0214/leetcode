package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/21 14:11
 */
public class Code25_K个一组翻转链表_hard {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;
        ListNode end = newHead;

        while (true){
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null)
                break;
            ListNode temp = end.next;
            ListNode start = pre.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = temp;
            pre = start;
            end = start;
        }
        return newHead.next;
    }

    private ListNode reverseList(ListNode head) {
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
