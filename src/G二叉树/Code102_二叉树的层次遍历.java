package G二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:松鼠
 * Date:2021/6/30 14:24
 */
public class Code102_二叉树的层次遍历 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(head);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list =new ArrayList<>();
        queue.add(root);
        TreeNode curEndNode = root; //当前层的最后一个结点
        TreeNode nextEndNode = null; //下一层的最后一个节点
        while (!queue.isEmpty()){
            TreeNode remove = queue.remove();
            list.add(remove.val);
            if(remove.left != null){
                queue.add(remove.left);
                nextEndNode = remove.left;
            }
            if(remove.right != null){
                queue.add(remove.right);
                nextEndNode = remove.right;
            }
            if(remove == curEndNode){
                res.add(list);
                curEndNode = nextEndNode;
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
