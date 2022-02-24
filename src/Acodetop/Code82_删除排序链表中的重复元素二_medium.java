package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/24 17:05
 */
public class Code82_删除排序链表中的重复元素二_medium {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;
        while (head != null && head.next != null) {
            ListNode nextNode = head.next;
            int flag = 0;
            while (nextNode != null && nextNode.val == head.val) {
                flag = 1;
                nextNode = nextNode.next;
            }
            if (flag == 1) {
                pre.next = nextNode;
                head = nextNode;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return newHead.next;


    }

}
