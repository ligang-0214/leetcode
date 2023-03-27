package B链表;

/**
 * Author:松鼠
 * Date:2021/6/18 15:38
 */
public class Code234_回文链表 {
    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
//        printLinkedList(head);
        System.out.print(isPalindrome(head) + " | ");

    }


    /**
     * 直接进阶版本  时间O(N) 额外空间：O(1)
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow; //pre指向中间位置
        fast = slow.next; //fast指向后半段反转链表的开头
        while(fast != null){
            ListNode temp = fast.next;
            fast.next = pre;
            pre = fast;  //pre最后指向end
            fast = temp; //fast和temp最后指向null
        }
        slow.next = null; //这里指向null  是为了最后把后半段链表再反转回来时起作用  不然的话没有结束标志了
        ListNode left = head;
        ListNode end = pre;
        while (left != null){
            if(pre.val != left.val)
                return false;
            pre = pre.next;
            left = left.next;
        }
        fast = end;
        pre = null;
        while (fast != null){
            fast = fast.next;
            end.next = pre;
            pre = end;
            end = fast;
        }
        return true;
    }
}
