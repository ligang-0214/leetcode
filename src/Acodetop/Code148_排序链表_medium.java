package Acodetop;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 松鼠
 * @data 2022/2/25 10:47
 */
public class Code148_排序链表_medium {

    public ListNode sortList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head);

        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }

        for (int i = 1; i < length; i = i * 2) {
            ListNode cur = dummy.next;
            ListNode pre = dummy;
            while (cur != null) {
                ListNode head1 = cur;
                for (int j = 1; j < i && cur.next != null; j++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int j = 1; j < i && cur != null && cur.next != null; j++) {
                    cur = cur.next;
                }
                ListNode next = null; //用来存下次将要归并的开头
                if (cur != null) {
                    next = cur.next;
                    cur.next = null; //将第二段也与后面的链表断开
                }
                cur = next;
                ListNode mergHead = mergTwoLists(head1, head2);
                pre.next = mergHead;
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }
        return dummy.next;
    }

    private ListNode mergTwoLists(ListNode head1, ListNode head2) {

        ListNode dummy = new ListNode(-1, null);
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    public ListNode sortList2(ListNode head){

        if(head == null){
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        while (head != null){ //注意把每个节点都断开  否则最后连一起之后 可能会出现循环链表
            priorityQueue.add(head);
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }

        ListNode dummy = new ListNode(-1, null);
        ListNode cur = dummy;
        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            cur.next = poll;
            cur = poll;
        }
        return dummy.next;


    }


}
