package G二叉树;

import java.util.*;

/**
 * Author:松鼠
 * Date:2021/7/3 14:21
 */
@SuppressWarnings("all")
public class Code113_路径总和二 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(4);
        head.left.left = new TreeNode(11);
        head.left.left.left = new TreeNode(7);
        head.left.left.right = new TreeNode(2);
        head.right = new TreeNode(8);
        head.right.left = new TreeNode(13);
        head.right.right = new TreeNode(4);
        head.right.right.left = new TreeNode(5);
        head.right.right.right = new TreeNode(1);
        Code_打印一个可视化的二叉树.printTree(head);
        System.out.println(pathSum(head,22).toString());
    }

    /**
     * DFS遍历
     */
    static List<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> list =new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        process(root,targetSum);
        return res;
    }
    public static void process(TreeNode root, int sum) {
        if (root == null) {
            return ;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if(sum == root.val){
                LinkedList<Integer> newList = (LinkedList<Integer>) list.clone();
                res.add(newList);
            }
        }
        process(root.left, sum - root.val);
        process(root.right, sum - root.val);
        list.removeLast();
    }


    /**
     * BFS遍历  使用map存某个节点的父节点
     */
    static List<List<Integer>> ret = new LinkedList<List<Integer>>();
    static Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
    public static List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }
        return ret;
    }

    /**
     * node结点就是找到的叶子节点，通过map一直找到根节点，记录这个链路
     * @param node
     */
    public static void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }

}
