package B链表;

/**
 * @author 松鼠
 * @data 2022/6/8 9:38
 */
public class Code160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null) {
            a++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            b++;
            tempB = tempB.next;
        }
        if (a > b) {
            tempA = headA;
            tempB = headB;
        } else {
            tempA = headB;
            tempB = headA;
        }

        int temp = a > b ? a - b : b - a;
        while (temp-- > 0) {
            tempA = tempA.next;
        }
        while (tempA != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}