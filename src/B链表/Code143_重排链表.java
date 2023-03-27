package B链表;

/**
 * Author:松鼠
 * Date:2021/9/22 21:25
 */
public class Code143_重排链表 {
    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
        PrintList.print(reorderList(head));
    }

    public static ListNode reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode fakeHead = head;
        ListNode fast = head;
        ListNode slow = head;
        //1、找到中点 或者左中点
        //如果链表长度为偶数 例如8个 那slow指向的就是4结点
        //如果链表长度为奇数 例如7个 那slow指向的就是4结点
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、反转链表的后半段
        ListNode cur = reverseList(slow.next);
        slow.next = null; //将前后半段断开
        //3、拼接链表
        while (fakeHead != null && cur != null){
            ListNode next = cur.next;
            cur.next = fakeHead.next;
            fakeHead.next = cur;
            fakeHead = fakeHead.next.next;
            cur = next;
        }
        return head;
    }
    public static ListNode reverseList(ListNode head) {
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
