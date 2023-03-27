package B链表;

/**
 * Author:松鼠
 * Date:2021/6/23 20:56
 */
public class Code725_分隔链表 {
    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        ListNode[] listNodes = splitListToParts(head, 3);
        for (int i = 0; i < listNodes.length; i++) {
            printLinkedList(listNodes[i]);
        }
    }

    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null){
            return new ListNode[k];
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        int subLength = length / k;
        int mod = length % k;
        ListNode[] res = new ListNode[k];
        cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            int flag = subLength + (mod-- > 0 ? 1 : 0);  //之前这里没加括号 就出了问题
            for (int j = 1; j < flag; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
