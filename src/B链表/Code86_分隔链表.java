package B链表;

import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;

/**
 * Author:松鼠
 * Date:2021/6/23 14:24
 */
@SuppressWarnings("all")
public class Code86_分隔链表 {
    public static void main(String[] args) {
        ListNode head=null;
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        PrintList.print(partitionPractice(head,3));

    }

    public static ListNode partition(ListNode head, int x) {
        ListNode sH = new ListNode(0); //小于链表的开头
        ListNode sE = sH; //小于链表的结尾
        ListNode q_bH = new ListNode(0);  //等于、大于链表的开头
        ListNode q_bE = q_bH;  //等于、大于链表的结尾
        while (head != null){
            if(head.val < x){ //建立小于x的链表
                sE.next = head;
                sE = head;
            }else { //建立等于 大于x的链表
                q_bE.next = head;
                q_bE = head;
            }
            head = head.next;
        }
        q_bE.next = null; //这个处理千万别忘了
        sE.next = q_bH.next;
        return sH.next;
    }

    public static ListNode partitionPractice(ListNode head, int x){
        if(head == null)
            return head;
        ListNode sH = null;
        ListNode sE = null;
        ListNode bH = null;
        ListNode bE = null;
        while (head != null){
            if(head.val < x){
                if(sH != null){
                    sE.next = head;
                    sE = sE.next;
                }else {
                    sH = head;
                    sE = head;
                }
            }else {
                if(bH != null){
                    bE.next = head;
                    bE = bE.next;
                }else {
                    bE = head;
                    bH = head;
                }
            }
            head = head.next;
        }
        bE.next = null;
        if(sE != null){
            sE.next = bH;
            return sH;
        }
        return bH;
    }
}
