package B链表;

/**
 * Author:松鼠
 * Date:2021/6/18 9:53
 */
public class Code83_删除排序链表中的重复元素 {
    public static void main(String[] args) {

    }



    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null ){
            return head;
        }
        ListNode cur1=head;

        /*ListNode cur2=head.next;
        while (cur2 != null) {
            if(cur1.val != cur2.val){
                cur1.next=cur2;
                cur1=cur2;
            }
            cur2=cur2.next;
            if(cur2 == null){
                cur1.next=null;
            }
        } */


        while (cur1.next != null){
            if(cur1.val == cur1.next.val){
                cur1.next = cur1.next.next;
            }else {
                cur1 = cur1.next;
            }
        }
        return head;


    }

    public static ListNode deleteDuplicatesPractice(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null){
            if(slow.val != fast.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = fast;
        return head;
    }
}
