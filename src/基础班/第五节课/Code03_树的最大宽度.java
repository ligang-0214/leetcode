package 基础班.第五节课;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Author:松鼠
 * Date:2021/6/24 19:11
 */
@SuppressWarnings("all")
public class Code03_树的最大宽度 {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);
//        System.out.println(getMaxWidth(head));
        Code02_打印一个可视化的二叉树.printTree(head);
    }

    public static int getMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        int maxWidth = 0;
        int curWidth = 0;
        int curLevel = 0;
        HashMap<Node, Integer> levelMap = new HashMap<>();//用来存储结点在第几层
        levelMap.put(head, 1);  //根节点在第一层
        LinkedList<Node> queue = new LinkedList<>();  //用队列来实现层次遍历
        queue.add(head);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            Node left = node.left;
            Node right = node.right;
            if (left != null) {
                levelMap.put(left, levelMap.get(node) + 1); //把左孩子结点存到map中
                queue.add(left); //添加到双向链表的结尾
            }
            if (right != null) {
                levelMap.put(right, levelMap.get(node) + 1);
                queue.add(right);
            }
            if (levelMap.get(node) > curLevel) {
                //如果弹出结点的层超过之前的层，就说明弹出的结点已经是新层了，所以宽度就设成1
                curWidth = 1;
                curLevel++;
//                curLevel = levelMap.get(node);
            } else {
                curWidth++;
            }
            maxWidth = Math.max(maxWidth, curWidth);
        }
        return maxWidth;
    }

    /**
     * 额外空间复杂度会更好一点 ，因为没有用到hashmap
     * @param head
     * @return
     */
    public static int getMaxWidth1(Node head){
        if (head == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int curWidth = 1;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEndNode = head; //当前层的最后一个结点
        Node nextEndNode = null; //下一层的最后一个节点
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            Node left = cur.left;
            Node right = cur.right;
            if(left != null){
                queue.add(left);
                nextEndNode = left;
            }
            if (right != null){
                queue.add(right);
                nextEndNode = right; //每次往队列新加结点都更新下层最后一个节点
            }
            if(curEndNode == cur){ //说明到达了最后一个节点
                max = Math.max(max,curWidth);//可以开始更新max了
                //下一次将要遍历下一层，将curEndNode、nextEndNode和curWidth重新初始化一下
                curEndNode = nextEndNode;
                nextEndNode = null;
                curWidth = 1;
            }else {
                curWidth++;
            }
        }
        return max;
    }
}
