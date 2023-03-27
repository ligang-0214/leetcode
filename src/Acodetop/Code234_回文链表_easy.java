package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/28 14:27
 */
public class Code234_回文链表_easy {

    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = new ListNode(-1 , head);
        ListNode slow = fast;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode secondHead = reverseLists(temp);
        while (head!= null && secondHead != null){
            if(head.val == secondHead.val){
                head = head.next;
                secondHead = secondHead.next;
            }else {
                return false;
            }
        }
        return true;
    }

    private ListNode reverseLists(ListNode head) {
        ListNode pre = null;
        ListNode cur = null;
        while (head != null){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

}
