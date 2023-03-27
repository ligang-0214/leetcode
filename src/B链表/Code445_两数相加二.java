package B链表;

/**
 * @author 松鼠
 * @data 2022/6/22 22:16
 */
public class Code445_两数相加二 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //1、翻转链表
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        //2、和code2 一样  两数相加
        ListNode dummy = new ListNode(-1, null);
        ListNode cur = dummy;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            ListNode temp = new ListNode((a + b + flag) % 10, null);
            flag = (a + b + flag) / 10;
            cur.next = temp;
            cur = temp;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag > 0) {
            ListNode temp = new ListNode(flag, null);
            cur.next = temp;
        }

        //3、把结果链表再翻转回来
        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head) {
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
