package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/7/12 9:06
 */
public class Code100_相同的数_easy {

    // 递归法
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        return process1(p, q);
    }

    private boolean process1(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        boolean b1 = process1(node1.left, node2.left);
        boolean b2 = process1(node1.right, node2.right);

        return b1 && b2;
    }


    /**
     * ------------------------------------------------------------------------------
     */


    // 迭代法的BFS
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(p);
        linkedList.addLast(q);

        while (!linkedList.isEmpty()) {
            TreeNode node1 = linkedList.removeFirst();
            TreeNode node2 = linkedList.removeFirst();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            linkedList.addLast(node1.left);
            linkedList.addLast(node2.left);

            linkedList.addLast(node1.right);
            linkedList.addLast(node2.right);
        }
        return true;

    }


}
