package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/22 9:18
 */
public class Code160_相交链表_easy {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int flag = 0;
        ListNode newHeadA = new ListNode(-1, headA);
        ListNode newHeadB = new ListNode(-1, headB);
        while (newHeadA.next != null) {
            flag++;
            newHeadA = newHeadA.next;
        }
        while (newHeadB.next != null) {
            flag--;
            newHeadB = newHeadB.next;
        }
        if (newHeadA != newHeadB) {
            return null;
        }

        newHeadA = flag > 0 ? headA : headB; //newHeadA指向更长的一条
        newHeadB = newHeadA == headA ? headB : headA;
        flag = flag > 0 ? flag : -flag;
        while (flag > 0) {
            newHeadA = newHeadA.next;
            flag--;
        }
        while (newHeadA != newHeadB) {
            newHeadA = newHeadA.next;
            newHeadB = newHeadB.next;
        }
        return newHeadA;


    }
}
