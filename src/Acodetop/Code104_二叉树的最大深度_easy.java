package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/2/26 14:58
 */
public class Code104_二叉树的最大深度_easy {

    //递归方式  深度优先遍历
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth1(root.left);
        int rightMax = maxDepth1(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

    //迭代方式  广度优先遍历
    public int maxDepth2(TreeNode root) {
        if(root == null)
            return 0;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        int res = 0;
        while (!linkedList.isEmpty()) {
            res++;
            int size = linkedList.size();
            while (size-- > 0) {
                TreeNode treeNode = linkedList.removeFirst();
                if (treeNode.left != null) {
                    linkedList.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    linkedList.addLast(treeNode.right);
                }
            }
        }
        return res;
    }

}
