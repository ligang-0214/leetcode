package B链表;


/**
 * Author:松鼠
 * Date:2021/6/18 16:55
 */
@SuppressWarnings("all")
public class Code92_反转链表二 {
    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        ListNode listNode = reverseBetween(head, 3, 4);
        ListNode listNode2 = reverseBetweenPractice(head, 3, 4);
        PrintList.print(listNode2);
    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || right - left  == 0){
            return head;
        }
        ListNode cur1=head;
        ListNode cur2=head;
        ListNode pre = null;
        ListNode l = null;
        int flag = left;
        left--;
        while (--left >= 0){
            if(left == 0 ){
                l = cur1;  //l->left 的前一个
            }
            cur1 = cur1.next; //cur->left
        }
        int step = right - flag + 1;
        cur2 = cur1;
        while(--step >= 0){ //反转链表
            cur1 = cur1.next;
            cur2.next = pre;
            pre = cur2;
            cur2 =cur1;
        }
        if(l == null){
            head.next = cur1;
            return pre;
        }else {
            cur2 = l.next;
            l.next = pre;
            cur2.next = cur1;
            return head;
        }
    }


    public static ListNode reverseBetweenPractice(ListNode head, int left, int right){
        if(head == null || head.next == null || (left == right))
            return head;
        ListNode newHead = new ListNode(-1,head);
        ListNode pre = newHead;
        int flag1 = right -left;
        while (flag1-- > 0){
            head = head.next;
        }
        left--;
        while (left-- > 0){
            pre = pre.next;
            head = head.next;
        }
        ListNode temp = head.next; //结束结点的下一位
        head.next = null;
        ListNode temp2 = pre.next; //需要反转链表的开头  反转完他就是结尾
        pre.next = reverseList(temp2);
        temp2.next = temp;
        return newHead.next;
    }
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
