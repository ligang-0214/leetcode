package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/20 19:25
 */
public class Code206_反转链表_easy {


    public ListNode reverseList(ListNode head) {
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
