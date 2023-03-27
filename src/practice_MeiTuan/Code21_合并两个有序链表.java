package practice_MeiTuan;

/**
 * @author 松鼠
 * @data 2022/3/29 15:33
 */
public class Code21_合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1 , null);
        ListNode pre = dummy;

        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                pre.next = list1;
                list1 = list1.next;
            }else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
            pre.next = null;
        }
        if (list1 != null){
            pre.next = list1;
        }
        if(list2 != null){
            pre.next = list2;
        }
        return dummy.next;
    }

}
