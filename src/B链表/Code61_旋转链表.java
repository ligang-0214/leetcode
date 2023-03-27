package B链表;

/**
 * Author:松鼠
 * Date:2021/6/23 9:32
 */
public class Code61_旋转链表 {
    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        PrintList.print(rotateRight(head,2));


    }


    public static ListNode rotateRight(ListNode head, int k) {
        ListNode fast = head;
        if (head == null){
            return head;
        }
        int flag = 0; //链表长度
        while (fast != null){
            fast = fast.next;
            flag++;
        }
        k = k % flag; //因为k可能大于链表长度  移动取余的部分才是真实的移动部分
        if(k == 0 ){
            return head;
        }
        fast = head;
        ListNode slow=new ListNode(0,head);
        while (fast.next != null){
            k--;
            if (k <= 0){
                slow = slow.next;
            }
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }

    public static ListNode rotateRightPractice(ListNode head, int k){
        if(head == null)
            return head;
        int i = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            i++;
        }
        k = k % i; //真实的截取长度
        if(k == 0)
            return head;
        ListNode end = head;
        ListNode pre = head;
//        while (k-->0){
//            end = end.next;
//        }
//        while (end.next != null){
//            end = end.next;
//            pre = pre.next;
//        }
        while (end.next != null){
            if(k-- <= 0)
                pre = pre.next;
            end = end.next;
        }
        end.next = head;
        head = pre.next;
        pre.next = null;
        return head;
    }
}
