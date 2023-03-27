package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/25 10:29
 */
public class Code2_两数相加_medium {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1, l1);
        int flag = 0;
        ListNode cur = dummy;
        while (l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + flag;
            ListNode node = new ListNode();
            node.val = sum >= 10 ? sum % 10 : sum;
            cur.next = node;
            cur = node;
            flag = sum >= 10 ? 1 : 0;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(flag == 1){
            cur.next = new ListNode(1 , null);
        }
        return dummy.next;
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
