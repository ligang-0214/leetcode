package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/7/12 9:57
 */
public class Code513_找树左下角的值_medium {

    // 迭代的方式 BFS
    public int findBottomLeftValue1(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int res = 0;
        if (root == null) {
            return res;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.removeFirst();
                if (i == 0) {
                    res = node.val;
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


    /**
     * ---------------------------------------------------------------------------------
     */


    // 递归的方式 DFS
    int res = 0;
    int height = -1;

    public int findBottomLeftValue2(TreeNode root) {
        process(root, 0);
        return res;
    }

    private void process(TreeNode root, int curHeight) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && curHeight > height) {
            height = curHeight;
            res = root.val;
        }
        process(root.left, curHeight + 1);
        process(root.right, curHeight + 1);
    }


}
