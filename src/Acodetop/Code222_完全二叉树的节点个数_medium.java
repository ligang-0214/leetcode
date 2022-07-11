package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/7/11 20:37
 */
public class Code222_完全二叉树的节点个数_medium {

    // 迭代法 BFS
    public int countNodes1(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        int res = 0;
        if (root == null) {
            return res;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                res++;
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




    // 递归法 DFS
    public int countNodes2(TreeNode root) {
        if(root == null)
            return 0;

        int left = countNodes2(root.left);
        int right = countNodes2(root.right);
        return left + right + 1;
    }

}
