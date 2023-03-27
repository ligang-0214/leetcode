package B链表;

/**
 * Author:松鼠
 * Date:2021/6/23 15:28
 */
@SuppressWarnings("all")
public class Code148_排序链表 {
    public static void main(String[] args) {
        ListNode head = null;
        //这个设置的原因是测试归并时是否达到稳定的排序，关键就在于处理两个链表相等时的情况。
        head = new ListNode(8,0);
        head.next = new ListNode(2,1);
        head.next.next = new ListNode(7,0);
        head.next.next.next = new ListNode(1,0);
        head.next.next.next.next = new ListNode(2,2);
        head.next.next.next.next.next = new ListNode(2,3);
        printLinkedList(head);
        printLinkedList(sortList(head));
    }
    public static void printLinkedList(ListNode node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.val + " "+node.flag+"||");
            node = node.next;
        }
        System.out.println();
    }

    //自底向上归并排序  迭代法
    // 看着挺多 其实不难  就是相当于把 K个一组翻转链表 和 合并链表  两个题组合了一下
    public static ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0; // 记录链表长度
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        //初始时每个子链表长度为1，之后每次为2*subLength，直到长度大于等于链表长度为止
        for (int subLength = 1; subLength < length; subLength = subLength*2) {
            // 这里之后就想象成是在做 K个一组翻转链表
            ListNode pre = dummyHead;
            ListNode cur = dummyHead.next;
            while (cur != null) {
                ListNode head1 = cur;//要归并的第一段链表的开头
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next; //要归并的下一段链表的开头
                cur.next = null;//第一段链表的末尾断开  防止影响归并
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null; //用来存下次将要归并的开头
                if (cur != null) {
                    next = cur.next;
                    cur.next = null; //将第二段也与后面的链表断开
                }
                cur = next;
                ListNode merged = merge(head1, head2); //合并链表
                pre.next = merged; //prev指向归并后返回的新表头
                while (pre.next != null) {
                    pre = pre.next; //prev指向归并的链表的最后一个节点
                }
            }
        }
        return dummyHead.next;
    }

    public static ListNode sortList1Practice(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode cur1 = head;
        int length = 0; //链表长度
        while (cur1 != null){
            length++;
            cur1 = cur1.next;
        }
        ListNode dummy = new ListNode(-1,head);
        for (int i = 1; i < length; i = i*2) {
            //每次开始一次新的归并时  要初始化一些信息
            ListNode cur = dummy.next;
            ListNode pre = dummy;
            while (cur != null){
                ListNode head1 = cur;
                for (int j = 1; j < i && cur.next != null ; j++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int j = 1; j < i && cur != null && cur.next != null ; j++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if(cur != null){
                    next = cur.next;
                    cur.next = null;
                }
                ListNode merge = merge(head1, head2);
                pre.next = merge;
                while (pre.next != null){
                    pre = pre.next;
                }
                pre.next = next;
                cur = next;
            }
        }
        return dummy.next;
    }

    //自顶向下归并排序  递归法
    //由于需要用到栈  空间复杂度是 logN 所以直接写迭代法  不写递归法了
    public static ListNode sortList2(ListNode head1){
        return sortList2(head1,null);
    }

    public static ListNode sortList2(ListNode head, ListNode tail) {
        //下面这两个判断尤其重要  我裂开了
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList2(head, mid);
        ListNode list2 = sortList2(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }


    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }


    /**
     * 使用21题的合并两个链表
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode head1=head;
        while (l1!=null && l2!=null){
            if(l1.val <= l2.val){
                head.next=l1;
                head=head.next;
                l1=l1.next;
            }else {
                head.next=l2;
                head=head.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            head.next=l2;
        }else {
            head.next=l1;
        }
        return head1.next;
    }


}
