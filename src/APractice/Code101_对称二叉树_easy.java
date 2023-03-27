package APractice;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/7/11 18:24
 */
public class Code101_对称二叉树_easy {

    // 递归实现
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        boolean b1 = process(left.left, right.right);
        boolean b2 = process(left.right, right.left);
        return b1 && b2;
    }

    /**
     * -------------------------------------------------------------
     */


    // 迭代实现 BFS  【不是很熟 ,有点没想到】
    public boolean isSymmetric2(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if(root == null){
            return true;
        }
        linkedList.addLast(root.left);
        linkedList.addLast(root.right);

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

}
