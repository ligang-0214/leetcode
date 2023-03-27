package 基础班.第五节课;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author:松鼠
 * Date:2021/6/28 16:12
 */
@SuppressWarnings("all")
public class Code07_最低公共祖先 {
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
        System.out.println(lowestCommonAncestor1(head, head.left.right, head.left.left.left).value);
    }


    public static Node lowestCommonAncestor1(Node head,Node o1,Node o2){
        HashMap<Node,Node> fartherMap = new HashMap<>();
        fartherMap.put(head,head);
        HashSet<Node> set = new HashSet<>();
        process(head,fartherMap);
        Node cur1 = o1;
        while (cur1 != fartherMap.get(cur1)){
            set.add(cur1);
            cur1 = fartherMap.get(cur1);
        }
        set.add(head);
        cur1 = o2;
        while (cur1 != fartherMap.get(cur1)){
            if(set.contains(cur1))
                return cur1;
            cur1 = fartherMap.get(cur1);
        }
        return head;
    }

    /**
     * 这里也用到了树形DP的套路，真的很好用，要学会思想
     * 生成每个节点的父节点，放到map中去
     * @param x
     * @param fartherMap
     */
    public static void process(Node x,HashMap<Node,Node> fartherMap){
        if(x == null){
            return;
        }
        fartherMap.put(x.left,x);
        fartherMap.put(x.right,x);
        process(x.left,fartherMap);
        process(x.right,fartherMap);
    }


    public static Node lowestCommonAncestor2(Node head, Node o1, Node o2) {
        /**
         注意p,q必然存在树内, 且所有节点的值唯一!!!
         递归思想, 对以root为根的(子)树进行查找p和q, 如果root == null || p || q 直接返回root
         表示对于当前树的查找已经完毕, 否则对左右子树进行查找, 根据左右子树的返回值判断:
         1. 左右子树的返回值都不为null, 由于值唯一左右子树的返回值就是p和q, 此时root为LCA
         2. 如果左右子树返回值只有一个不为null, 说明只有p和q存在与左或右子树中, 最先找到的那个节点为LCA
         3. 左右子树返回值均为null, p和q均不在树中, 返回null
         **/
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestCommonAncestor2(head.left, o1, o2);
        Node right = lowestCommonAncestor2(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }else if(left == null && right == null){
            return null;
        }
        return left != null ? left : right;
    }


}
