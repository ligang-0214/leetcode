package Acodetop;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 松鼠
 * @data 2022/2/20 19:35
 */
public class Code146_LRU缓存_medium {

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


    int cap;
    int size;
    Map<Integer,DoubleListNode> map = new HashMap<>();
    DoubleListNode head,tail;

    //初始化
    public void LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        head = new DoubleListNode();
        tail = new DoubleListNode();
        head.next = tail;
        tail.pre = head;
    }

    //获取元素
    public int get(int key) {
        //如果不包含 返回-1
        if(!map.containsKey(key)){
            return -1;
        }
        DoubleListNode cur = map.get(key);//获取当前元素
        //将此元素在当前位置移除
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        //将此元素添加到头部
        cur.next = head.next;
        head.next = cur;
        cur.pre = head;
        cur.next.pre = cur;
        //返回当前元素的val
        return cur.val;
    }

    //添加元素
    public void put(int key, int value) {
        DoubleListNode cur = map.get(key);
        if(cur != null){//如果存在此节点，则更新val即可
            cur.val = value;
            //将此元素在当前位置移除
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            //将此元素添加到头部
            cur.next = head.next;
            head.next = cur;
            cur.pre = head;
            cur.next.pre = cur;
        }else { // 如果不存在此节点
            DoubleListNode newNode = new DoubleListNode(key, value);
            map.put(key,newNode);//将新元素添加到map中
            //将此元素添加到头部
            newNode.next = head.next;
            head.next = newNode;
            newNode.pre = head;
            newNode.next.pre = newNode;
            size++;
            if(size > cap){ // 如果超过最大容量则删除最后一个节点
                map.remove(tail.pre.key); // 将map中的此元素删除
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
                size--;
            }
        }
    }




}
