package B链表;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Author:松鼠
 * Date:2021/9/24 9:31
 */
public class Test {
    public static void main(String[] args) {
        LRUCache(2);
        put(1,1);
        put(2,2);
        System.out.println("get 1 的结果：" + get(1));
        for (DoubleListNode node: list) {
            System.out.print(node.key + " " + node.val);
        }
        System.out.println();
        put(3,3);
        for (DoubleListNode node: list) {
            System.out.print(node.key + " " + node.val);
        }
        System.out.println();
        System.out.println("get 2 的结果：" + get(2));
        for (DoubleListNode node: list) {
            System.out.print(node.key + " " + node.val);
        }
        System.out.println();

    }

    static class DoubleListNode{
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

    static Map<Integer,DoubleListNode> map = new HashMap<>();
    static int size; //当前链表中结点的数量
    static int capacity; //最大容量
    static LinkedList<DoubleListNode> list ;

    public static void LRUCache(int capacity1) {
        size = 0;
        capacity = capacity1;
        list = new LinkedList<>();
    }

    public static int get(int key) {
        DoubleListNode cur = map.get(key);
        if(cur == null){
            return -1;
        }
        list.remove(cur);
        list.addFirst(cur);
        return cur.val;
    }

    public static void put(int key, int value) {
        DoubleListNode cur = map.get(key);
        if(cur != null){
            cur.val = value;
            list.remove(cur);
            list.addFirst(cur);
        }else {
            DoubleListNode putNode = new DoubleListNode(key, value);
            map.put(key, putNode);
            size++;
            list.addFirst(putNode);
            if(size > capacity){
                map.remove(list.getLast().key);
                list.removeLast();
                size--;
            }
        }
    }
}
