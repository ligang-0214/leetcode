package B链表;

/**
 * @author 松鼠
 * @data 2022/6/22 14:51
 * <p>
 * 题目描述：
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 * 示例：
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 */
public class Code补充_排序奇升偶降链表 {


    /**
     * 1、拆分链表
     * 2、将偶数链表翻转
     * 3、合并两个有序链表
     *
     * @param head
     * @return
     */
    public ListNode sortOddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //1、拆分链表
        ListNode oddHead = new ListNode();
        ListNode oddEnd = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenEnd = evenHead;
        int flag = 1;
        while (head != null) {
            if (flag % 2 == 1) {
                oddEnd.next = head;
                oddEnd = head;
            } else {
                evenEnd.next = head;
                evenEnd = head;
            }
            head = head.next;
            flag++;
        }
        oddEnd.next = null;
        evenEnd.next = null;
        //2.翻转链表
        evenHead.next = reverseList(evenHead.next);
        //3.合并链表
        return mergeList(oddHead.next, oddHead.next);


    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode head1 = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            head.next = l2;
        } else {
            head.next = l1;
        }
        return head1.next;
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
