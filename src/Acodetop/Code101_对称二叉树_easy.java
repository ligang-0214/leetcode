package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/2/28 14:48
 */
public class Code101_对称二叉树_easy {

    //层序遍历 迭代
    public boolean isSymmetric1(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            TreeNode node1 = linkedList.removeFirst();
            TreeNode node2 = linkedList.removeFirst();
            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 != null && node2 != null) {
                if (node1.val != node2.val) {
                    return false;
                }
            } else {
                return false;
            }

            linkedList.addLast(node1.left);
            linkedList.addLast(node2.right);

            linkedList.addLast(node1.right);
            linkedList.addLast(node2.left);
        }
        return true;
    }

    //递归的方式
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null){
            return true;
        }
        return process(root.left,root.right);
    }
    public  static boolean process(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return process(t1.left,t2.right) && process(t1.right,t2.left);
    }

}
