package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/24 17:31
 */
public class Code83_删除排序链表中的重复元素_easy {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode dummy = new ListNode(-1, head);
        while (head != null){
            ListNode temp = head.next;
            while (temp != null && temp.val == head.val){
                temp = temp.next;
            }
            head.next = temp;
            head = temp;
        }
        return dummy.next;
    }

}
