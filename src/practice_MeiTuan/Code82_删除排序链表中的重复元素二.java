package practice_MeiTuan;

/**
 * @author 松鼠
 * @data 2022/3/29 18:08
 */
public class Code82_删除排序链表中的重复元素二 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (head != null && head.next != null){
            if(head.val != head.next.val){
                pre = head;
                head = head.next;
            }else {
                while (head != null && head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                pre.next = head.next;
                head = pre.next;
            }
        }
        return dummy.next;

    }

}
