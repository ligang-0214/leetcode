package practice_MeiTuan;

/**
 * @author 松鼠
 * @data 2022/3/29 15:07
 */
public class Code141_环形链表 {

    //判断是否有环
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != slow){
            if(fast.next == null || fast.next.next == null){
                return false;
            }else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return true;
    }

}
