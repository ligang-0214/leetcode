package B链表;

/**
 * Author:松鼠
 * Date:2021/9/20 16:52
 */
public class Code25_K个一组翻转链表 {
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
        PrintList.print(reverseKGroup1(head,3));
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        ListNode newHead = new ListNode(-1,head);
        ListNode pre = newHead;
        ListNode end = newHead; //看好这个end起始指向哪里
        while (true){
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null) //如果是因为这组不够K个 那就直接结束循环
                break;
            ListNode temp = end.next;
            ListNode star = pre.next;
            end.next = null;
            pre.next = reverseList(star);
            star.next = temp;
            pre = star;
            end = pre;
        }
        //字节会要求 剩余的也需要翻转  加上这句就行了
//        pre.next = reverseList(pre.next);
        return newHead.next;
    }

    public static ListNode reverseList(ListNode head){
        //这种多定义一个变量  我觉得要舒服一点
        ListNode pre = null;
        ListNode cur = null;
        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }


    //递归的写法 也比较好理解
    public static ListNode reverseKGroup2(ListNode head, int k){
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) { //只要count == k   那么cur就是指向下一组的开头（也可能是null）
            cur = reverseKGroup2(cur, k); //此时的cur就是下一组的开头（可能处理过 也可能没处理过）
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    public static ListNode reverseKGroupPractice1(ListNode head, int k){
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if(count == k){
            cur = reverseKGroupPractice1(cur,k);
            while (count-->0){
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }

}
