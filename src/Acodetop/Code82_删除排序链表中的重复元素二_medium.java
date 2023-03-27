package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/24 17:05
 */
public class Code82_删除排序链表中的重复元素二_medium {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if(cur.val != cur.next.val){
                pre = cur;
                cur = cur.next;
            }else {
                while (cur != null && cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = pre.next;
            }
        }
        return dummy.next;


    }

}
