package practice_MeiTuan;

import Acodetop.Code146_LRU缓存_medium;

import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/3/29 20:50
 */
public class Code146_LRU缓存 {


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
class LRUCache{
    int capacity;
    HashMap<Integer , DoubleListNode> map;
    DoubleListNode head;
    DoubleListNode end;
    int size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleListNode(-1 , -1);
        end = new DoubleListNode(-1 , -1);
        head.next = end;
        end.pre = head;
        map = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            DoubleListNode node = map.get(key);
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            node.pre = head;
            return node.val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DoubleListNode node = map.get(key);
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            node.pre = head;
            node.val = value;
        }else {
            size++;
            DoubleListNode newNode = new DoubleListNode(key, value);
            map.put(key , newNode);
            newNode.next = head.next;
            head.next = newNode;
            newNode.next.pre = newNode;
            newNode.pre = head;
            if(size > capacity){
                map.remove(end.pre.key);
                end.pre.pre.next = end;
                end.pre = end.pre.pre;
                size--;
            }
        }
    }
}
