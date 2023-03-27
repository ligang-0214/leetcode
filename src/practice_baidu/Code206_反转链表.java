package practice_baidu;


/**
 * @author 松鼠
 * @data 2022/4/10 9:57
 */
public class Code206_反转链表 {
    public ListNode reverseList(ListNode head) {
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
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
