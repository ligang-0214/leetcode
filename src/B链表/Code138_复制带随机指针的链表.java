package B链表;

import java.util.HashMap;

/**
 * Author:松鼠
 * Date:2021/9/22 16:36
 */
public class Code138_复制带随机指针的链表 {
    public static void main(String[] args) {

    }

    public static ListNode copyRandomList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode cur=head;
        while(cur != null){ //生成新节点  并插入到原链表中
            ListNode newNode=new ListNode(cur.val);
            newNode.next=cur.next;
            cur.next=newNode;
            cur=cur.next.next;
        }
        cur=head;
        while (cur != null){ //设置rand
            cur.next.random=cur.random == null ? null : cur.random.next;
            cur=cur.next.next;
        }
        ListNode result = head.next; //标记复制后的开头
        cur=head;
        ListNode flag=null;
        while (cur != null){ //把复制的内容取出来
            flag=cur.next;
            cur.next=flag.next;
            flag.next=cur.next != null ? cur.next.next : null;
            cur=cur.next;
        }
        return result;

    }

    public static ListNode copyRandomListPractice(ListNode head){
        if(head == null)
            return null;
        HashMap<ListNode,ListNode> map = new HashMap<>();
        ListNode fakeHead = head;
        //先把链表遍历一遍 把老的结点和新节点映射起来
        while (fakeHead != null){
            ListNode newHead = new ListNode(fakeHead.val); //这里就只赋值  next和random没有初始化
            map.put(fakeHead,newHead);
            fakeHead = fakeHead.next;
        }
        ListNode dummy = new ListNode(-1,map.get(head));
        while (head != null){
            ListNode fakeCur = map.get(head);
            if(head.next != null){ //设置新节点的next
                fakeCur.next = map.get(head.next);
            }
            ListNode fakeRan = map.get(head.random);
            fakeCur.random = fakeRan; //设置新节点的random
            head = head.next;
        }
        return dummy.next;
    }
}
