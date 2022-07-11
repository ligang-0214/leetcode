package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/7/11 17:04
 */
public class Code111_二叉树的最小深度_easy {

    // 递归的方式  DFS
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftMin = minDepth1(root.left);
        int rightMin = minDepth1(root.right);

        if (leftMin == 0 || rightMin == 0) {
            return leftMin == 0 ? rightMin + 1 : leftMin + 1;
        }

        return Math.min(leftMin, rightMin) + 1;
    }

    /**
     * ------------------------------------------------------------------
     */


    // 迭代的方式  BFS
    public int minDepth2(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int res = 0;
        if (root == null) {
            return res;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            res++;
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.removeFirst();
                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) {
                    linkedList.addLast(node.left);
                }
                if (node.right != null) {
                    linkedList.addLast(node.right);
                }
            }
        }
        return res;
    }


}
