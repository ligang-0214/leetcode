package APractice;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/7/11 10:30
 */
public class Code104_二叉树的最大深度_easy {

    // 广度优先遍历  BFS
    public int maxDepth1(TreeNode root) {
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

    /**
     * -----------------------------------------------------------------------------------------
     */

    // 深度优先遍历  DFS
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left, right) + 1;
    }

}
