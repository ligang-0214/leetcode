package Acodetop;


/**
 * @author 松鼠
 * @data 2022/2/21 20:08
 */
public class Code21_合并两个有序链表_easy {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode newHead = new ListNode(-1,null);
        ListNode cur = newHead;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;
        }else {
            cur.next = l1;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode list1 = null;
        list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(5);

        ListNode list2 = null;
        list2 = new ListNode(2);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(4);
        list2.next.next.next = new ListNode(5);
        list2.next.next.next.next = new ListNode(6);

        ListNode node = mergeTwoListsQuChong(list1, list2);
        System.out.print("打印链表内容: ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    //面试会要求去重
    public static ListNode mergeTwoListsQuChong(ListNode l1, ListNode l2){
        ListNode newHead = new ListNode(-1,null);
        ListNode cur = newHead;

        while (l1 != null && l2 != null){
            while (cur.val == l1.val){
                l1 = l1.next;
            }
            while (cur.val == l2.val){
                l2 = l2.next;
            }
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        while (cur.val == l2.val){
            l2 = l2.next;
        }
        if(l1 == null){
            cur.next = l2;
        }else {
            cur.next = l1;
        }
        return newHead.next;
    }
}
