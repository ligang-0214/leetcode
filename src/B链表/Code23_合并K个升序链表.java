package B链表;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import javax.swing.plaf.IconUIResource;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author:松鼠
 * Date:2021/9/20 14:50
 */
public class Code23_合并K个升序链表 {
    public static void main(String[] args) {

    }

    //这个解法  简直是作弊  哈哈哈哈
    public static ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        ListNode cur = null;
        for (int i = 0; i < lists.length; i++) {
            cur = mergeTwoLists(cur, lists[i]);
        }
        return cur;

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode newHead = new ListNode(-1,null);
        ListNode cur = newHead;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

    //使用优先级队列的方式处理  我觉得比较好
    public static ListNode mergeKLists2(ListNode[] lists){
        if(lists == null || lists.length == 0)
            return null;
        //小根堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>((o1,o2)->{return o1.val - o2.val;});
        ListNode newHead = new ListNode(-1,null);
        ListNode cur = newHead;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] == null){ // 这个判断比忘了 因为可能测试用例中某些元素为空
                continue;
            }
            priorityQueue.add(lists[i]);
        }
        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            if(poll.next != null)
                priorityQueue.add(poll.next);
            cur.next = poll;
            cur = poll;
        }
        return newHead.next;
    }

}
