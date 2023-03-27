package B链表;

/**
 * Author:松鼠
 * Date:2021/9/17 15:34
 */
public class Code203_移除链表元素 {
    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = removeElements(head, 3);
        PrintList.print(listNode);

    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return newHead.next;

    }
}
