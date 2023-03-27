package B链表;

import java.util.List;

/**
 * Author:松鼠
 * Date:2021/9/17 16:08
 */
public class Code206_反转链表 {
    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        PrintList.print(reverseList1(head));
        PrintList.print(reverseList2(head));

    }

    //迭代法/双指针法
    public static ListNode reverseList1(ListNode head){
        ListNode pre = null;
        ListNode cur = null;
        while (head != null){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
        //这种多定义一个变量  我觉得比上面的要舒服一点
//        ListNode prev = null;
//        ListNode cur = head;
//        ListNode temp = null;
//        while (cur != null) {
//            temp = cur.next;// 保存下一个节点
//            cur.next = prev;
//            prev = cur;
//            cur = temp;
//        }
//        return prev;
    }

    public static ListNode reverseList2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
//        newHead.next = head;  //千万不能这样写  看清楚喽  这个newHead一直都是头
        head.next = null;
        return newHead;
    }

}
