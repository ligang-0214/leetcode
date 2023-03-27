package practice_MeiTuan;

/**
 * @author 松鼠
 * @data 2022/3/29 15:23
 */
public class Code142_环形链表三 {

    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode listNode = new ListNode(3);
        head.next.next = listNode;
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8,listNode);
        System.out.println(detectCycle(head));
    }

    //判断环的长度
    public static int detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return -1;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return -1;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        int flag = 1;
        fast = fast.next;
        while (fast != slow){
            flag++;
            fast = fast.next;
        }
        return flag;
    }

}
