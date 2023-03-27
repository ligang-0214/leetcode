package practice_MeiTuan;

import java.util.PriorityQueue;

/**
 * @author 松鼠
 * @data 2022/3/30 14:16
 */
public class Code23_合并K个升序链表 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1, null);
        ListNode cur = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1 , o2 )->{return o1.val - o2.val;});
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] == null){
                continue;
            }
            queue.add(lists[i]);
        }

        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            if(node.next != null){
                queue.add(node.next);
            }
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }

}
