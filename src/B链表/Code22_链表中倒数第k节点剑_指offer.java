package B链表;

/**
 * Author:松鼠
 * Date:2021/6/18 10:42
 */
public class Code22_链表中倒数第k节点剑_指offer {
    public static void main(String[] args) {

    }


    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur=head;
        ListNode res=null;
        while (cur != null){
            k--;
            if(k==0){
                res = head;
            }
            if (k < 0){
                res = res.next;
            }
            cur = cur.next;
        }
        return res;
    }


}
