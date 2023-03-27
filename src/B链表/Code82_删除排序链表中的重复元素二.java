package B链表;

/**
 * Author:松鼠
 * Date:2021/6/23 10:16
 */
public class Code82_删除排序链表中的重复元素二 {
    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        PrintList.print(deleteDuplicates(head));
    }


    /**
     * 官方解答  但是我还是更喜欢我的解法  多一个变量就是看起来直观一些
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }



    public ListNode deleteDuplicatesNowCoder (ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int temp = cur.val;
                while(cur != null &&  cur.val == temp){
                    cur = cur.next;
                }
                pre.next = cur;
            }else{
                pre = cur;
                cur =cur.next;
            }
        }
        return dummy.next;
    }


}
