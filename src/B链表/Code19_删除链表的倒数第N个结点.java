package B链表;

/**
 * Author:松鼠
 * Date:2021/6/18 14:22
 */
@SuppressWarnings("all")
public class Code19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }


    /**
     * 我以前怎么能写出这么啰嗦的代码。。。。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(n == 0){
            return head;
        }
        ListNode fast=head;
        ListNode slow=null;
        ListNode pre=null;
        while (fast != null){
            n--;
            if(n==0){
                slow = head;
            }
            if (n == -1){
                pre = head;
                slow = slow.next;
            }
            if (n < -1){
                slow = slow.next;
                pre = pre.next;
            }
            fast = fast.next;
        }
        if(slow == null && pre == null){
            return head;
        }
        if(slow == head){
            return head.next;
        }
        pre.next=slow.next;
        return head;
    }

    public ListNode removeNthFromEndPractice1(ListNode head, int n){
        if(head == null || n == 0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (n-- > 0){
            fast = fast.next;
        }
        if(fast == null)
            return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEndPractice2(ListNode head, int n){
        ListNode dummy = new ListNode(-1 , head);
        ListNode fast = head;
        ListNode slow = dummy;
        while(n-- > 0){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
