package B链表;

/**
 * Author:松鼠
 * Date:2021/6/21 17:15
 */
@SuppressWarnings("all")
public class Code2_两数相加 {
    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode head1=null;
        head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(9);
        PrintList.print(addTwoNumbersPractice(head,head1));
        PrintList.print(addTwoNumbers(head,head1));

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1 , null);
        ListNode cur = dummy;
        int flag = 0;
        while(l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            ListNode tempNode = new ListNode((num1 + num2 + flag) % 10 , null);
            cur.next = tempNode;
            cur = cur.next;
            flag = (num1 + num2 + flag) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(flag > 0){
            cur.next = new ListNode(flag , null);
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbersPractice(ListNode l1, ListNode l2){
        ListNode head1 = new ListNode(0, null);
        ListNode head2 = head1;
        int flag = 0;
        while (l1 != null || l2 != null){
            ListNode temp = new ListNode();
            head1.next = temp;
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + flag;
            if(sum >= 10){
                temp.val = sum%10;
                flag = 1;
            }else {
                temp.val = sum;
                flag = 0;
            }
            head1 = head1.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if(flag == 1){
            head1.next = new ListNode(1,null);
        }
        return head2.next;
    }
}
