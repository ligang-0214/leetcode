package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/24 17:31
 */
public class Code83_删除排序链表中的重复元素_easy {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            while (temp != null && temp.val == cur.val){
                temp = temp.next;
            }
            cur.next = temp;
            cur = temp;
        }
        return dummy.next;
    }

}
