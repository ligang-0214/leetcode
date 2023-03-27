package B链表;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Author:松鼠
 * Date:2021/9/23 9:04
 */
public class Code146_LRU缓存机制 {
    public static void main(String[] args) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        linkedList.add(new ListNode(1));
        linkedList.add(new ListNode(2));
        System.out.println(linkedList.toString());
        linkedList.addFirst(new ListNode(2));
    }
    //定义双向链表
    class DoubleListNode{
        int key;
        int val;
        DoubleListNode pre;
        DoubleListNode next;
        DoubleListNode(){
        }
        DoubleListNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer,DoubleListNode> map = new HashMap<>();
    int size; //当前链表中结点的数量
    int capacity; //最大容量
    DoubleListNode head,tail; //哑节点 头和尾

    public void LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DoubleListNode();
        tail = new DoubleListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleListNode cur = map.get(key);
        if(cur == null){
            return -1;
        }
        //处理当前结点的前后结点
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        //插入到头部
        cur.next = head.next;
        cur.next.pre = cur;
        head.next = cur;
        cur.pre = head;
        return cur.val;
    }

    public void put(int key, int value) {
        DoubleListNode cur = map.get(key);
        if(cur != null){
            cur.val = value;
            //处理当前结点的前后结点
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            //插入到头部
            cur.next = head.next;
            cur.next.pre = cur;
            head.next = cur;
            cur.pre = head;
        }else {
            DoubleListNode putNode = new DoubleListNode(key, value);
            map.put(key, putNode);
            size++;
            putNode.next = head.next;
            putNode.next.pre = putNode;
            head.next = putNode;
            putNode.pre = head;
            if(size > capacity){
                map.remove(tail.pre.key);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
                size--;
            }
        }
    }

}
