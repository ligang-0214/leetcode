package B链表;

/**
 * Author:松鼠
 * Date:2021/9/17 15:57
 */
public class PrintList {
    public static void print(ListNode node) {
        System.out.print("打印链表内容: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
}
