package Acodetop;

/**
 * Author:松鼠
 * Date:2021/6/18 15:43
 */
public class ListNode {
    int val;
    int flag;
    ListNode next;
    ListNode random;
    ListNode() {
    }
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, int flag) {
        this.val = val;
        this.flag = flag;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
