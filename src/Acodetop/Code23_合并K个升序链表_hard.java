package Acodetop;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 松鼠
 * @data 2022/2/23 14:36
 */
public class Code23_合并K个升序链表_hard {

    //网友：快手一面，先让合并两个有序链表，然后让分析复杂度，接着让口述合并k个排序链表的思路，
    //答出排序后又问有没有其他办法，当时不知道优先队列可以解，这应该是一套组合拳。
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }

        ListNode cur = null;
        for (int i = 0; i < lists.length; i++) {
            cur = mergeTwoLists(cur, lists[i]);
        }
        return cur;
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode newHead = new ListNode(-1, null);
        ListNode cur = newHead;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return newHead.next;
    }


    // 优先级队列来解决
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>();

        //把每条链表的第一个元素加入到小根堆中
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            priorityQueue.add(lists[i]);
        }

        ListNode newHead = new ListNode(-1, null);
        ListNode cur = newHead;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            cur.next = poll;
            cur = cur.next;
        }

        return newHead.next;
    }


}
