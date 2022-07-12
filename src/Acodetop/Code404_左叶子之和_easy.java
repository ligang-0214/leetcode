package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/7/12 9:34
 */
public class Code404_左叶子之和_easy {

    // 迭代法 BFS
    public int sumOfLeftLeaves1(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int res = 0;
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            TreeNode node = linkedList.removeFirst();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                res += node.left.val;
            }
            if (node.left != null) {
                linkedList.addLast(node.left);
            }
            if (node.right != null) {
                linkedList.addLast(node.right);
            }
        }
        return res;
    }

    /**
     * ---------------------------------------------------------------------------------------
     */

    // 递归的方式
    int res = 0;
    public int sumOfLeftLeaves2(TreeNode root) {
        process(root);
        return res;

    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }

        process(root.left);
        process(root.right);
    }


}
