package B链表;

/**
 * Author:松鼠
 * Date:2021/9/22 20:40
 */
public class Code141_环形链表 {
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
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return false;
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow){
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
//            System.out.println("fast ：" + fast.val);
//            System.out.println("slow ：" + slow.val);
        }
        //问题一：问入环节点
        //问题二：问入环节点的下标位置
        //问题三：问环的长度


        System.out.println("fast ：" + fast.val);
        System.out.println("slow ：" + slow.val);

        //如何知道环的长度呢？
        //方法是，快慢指针相遇后继续移动，直到第二次相遇。两次相遇间的移动次数即为环的长度。
        // 或者 快指针指向开头  然后快指针两步  慢指针一步  再次相遇的步数
//        int flag = 1;
//        slow = slow.next;
//        fast = fast.next.next;
        int flag = 0;
        fast = head;
        while (fast != slow){
            flag++;
            slow = slow.next;
            fast = fast.next.next;
//            System.out.println("fast ：" + fast.val);
//            System.out.println("slow ：" + slow.val);
        }
        System.out.println(flag);
        return true;

        /*
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
         */

    }
}
