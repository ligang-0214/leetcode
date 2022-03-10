package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/10 16:08
 */
public class Code24_两两交换链表中的节点_medium {

    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = swapPairs(head);
    }

    //这不就相当于K个一组反转链表吗
    public static ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head;
        ListNode preHead = dummy;

        while (cur != null){
            cur = cur.next;
            if(cur == null){
                break;
            }
            ListNode temp = cur.next;
            ListNode start = preHead.next;
            cur.next = null;
            preHead.next = reverseList(start);
            start.next = temp;
            preHead = start;
            cur = temp;
        }
        return dummy.next;
    }

    private static ListNode reverseList(ListNode head) {
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
