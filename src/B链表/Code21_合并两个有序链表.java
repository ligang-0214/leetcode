package B链表;

/**
 * Author:松鼠
 * Date:2021/6/16 16:35
 */
@SuppressWarnings("all")
public class Code21_合并两个有序链表 {
    public static void main(String[] args) {
        ListNode head = null;
        ListNode head1 = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head1 = new ListNode(2);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(5);
        PrintList.print(head);
        PrintList.print(head1);
        ListNode listNode = mergeTwoLists1(head, head1);
        PrintList.print(listNode);
        PrintList.print(head);
        PrintList.print(head1);
    }




    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }


    /**
     * 简单解法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode head1=head;
        while (l1!=null && l2!=null){
            if(l1.val < l2.val){
                head.next=l1;
                head=head.next;
                l1=l1.next;
            }else {
                head.next=l2;
                head=head.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            head.next=l2;
        }else {
            head.next=l1;
        }
        return head1.next;
    }

    public static ListNode mergeTwoListsPractice1(ListNode l1, ListNode l2){
        ListNode newHead = new ListNode(-1,null);
        ListNode cur = newHead;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

}
