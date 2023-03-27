package B链表;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * Author:松鼠
 * Date:2021/6/24 9:12
 */
@SuppressWarnings("all")
public class Code328_奇偶链表 {
    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
        printLinkedList(oddEvenListPractice(head));
    }

    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    // 我觉得我下面自己的写法更容易理解一些   也更清晰些
    public static ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static ListNode oddEvenListPractice(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode();
        ListNode oddEnd = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenEnd = evenHead;
        int flag = 1;
        while (head != null) {
            if (flag % 2 == 1) {
                oddEnd.next = head;
                oddEnd = head;
            } else {
                evenEnd.next = head;
                evenEnd = head;
            }
            head = head.next;
            flag++;
        }
        oddEnd.next = evenHead.next;
        evenEnd.next = null;
        return oddHead.next;

    }

}
