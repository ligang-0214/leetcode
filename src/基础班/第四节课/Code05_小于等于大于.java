package 基础班.第四节课;

import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/6/15 10:34
 */
public class Code05_小于等于大于 {
    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
//        head1 = arrPartition(head1, 5);
        head1 = listPartition(head1, 5);
        printLinkedList(head1);
    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 使用额外的数组来实现对链表的partition，
     * 额外空间复杂度比较高。
     * @param head
     * @param pivot
     * @return
     */
    public static Node arrPartition(Node head,int pivot){
        if(head==null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {  //获取链表长度
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];//用来存储链表结构的数据
        cur=head;  i=0;
        while (cur!=null){ //将链表中的数据存到数组中
            nodeArr[i++]=cur;
            cur=cur.next;
        }
        int right=nodeArr.length,left=-1;
        i=0;
        while(i<right){ //进行partition
            if(nodeArr[i].value==pivot)
                i++;
            else if(nodeArr[i].value < pivot){
                swap(nodeArr,++left,i++);
            }else{
                swap(nodeArr,--right,i);
            }
        }
        for (i = 1; i < nodeArr.length; i++) { //将数组串起来
            nodeArr[i-1].next=nodeArr[i];
        }
        nodeArr[i-1].next=null;//这句别忘了
        return nodeArr[0];//返回链表的头
    }

    public static void swap(Node[] arr, int i, int j) {
        Node tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 使用简单的几个变量进行实现   满足进阶题目的要求
     * @param head
     * @param pivot
     * @return
     */
    public static Node listPartition(Node head, int pivot){
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node

        while(head!=null){
            next=head.next;
            head.next=null; //为了防止局部循环的产生
            if(head.value < pivot){
                if(sH==null){
                    sH=head;
                    sT=head;
                }else {
                    sH.next=head;
                    sT=head;
                }
            }
            if(head.value == pivot){
                if(eH==null){
                    eH=head;
                    eT=head;
                }else {
                    eH.next=head;
                    eT=head;
                }
            }
            if(head.value > pivot){
                if(bH==null){
                    bH=head;
                    bT=head;
                }else {
                    bH.next=head;
                    bT=head;
                }
            }
            head=next;
        }


        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        //bH指针是否为空无所谓  因为反正在最后

        head = sH != null ? sH : eH != null ? eH : bH ;

        return head;

    }


    /**
     * 打印链表
     * @param node
     */
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
