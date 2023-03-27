package 基础班.第四节课;

/**
 * Author:松鼠
 * Date:2021/6/13 15:24
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
 * 【要求】 如果两个链表的长度之和为N，时间复杂度要求为O(N)，额外空间复
 * 杂度要求为O(1)
 */
public class Code03_PrintCommonPart {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 打印公共部分
     * @param head1
     * @param head2
     */
    public static void printCommonPart(Node head1, Node head2){
        while (head1.next!=null && head2.next!=null){
            if(head1.value==head2.value){
                System.out.println(head1.value+",");
                head1=head1.next;
                head2=head2.next;
            }
            if(head1.value < head2.value){
                head1=head1.next;
            }
            if(head1.value > head2.value){
                head2=head2.next;
            }
        }
    }

}
