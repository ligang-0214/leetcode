package G二叉树;

import java.util.LinkedList;

/**
 * Author:松鼠
 * Date:2021/7/2 21:06
 */
public class Code112_路经总和 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.left.left.left = new TreeNode(4);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
//        Code_打印一个可视化的二叉树.printTree(head);
        System.out.println("是否有匹配的路径和：" + hasPathSum1(head, 20));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queNode = new LinkedList<>();
        LinkedList<Integer> queValNode = new LinkedList<>();
        queNode.add(root);
        queValNode.add(root.val);
        while (!queNode.isEmpty()) {
            TreeNode remove = queNode.remove();
            Integer removeVal = queValNode.remove();
            if (remove.left == null && remove.right == null) {
                if (removeVal == targetSum)
                    return true;
                continue;
            }
            if (remove.left != null) {
                queNode.add(remove.left);
                queValNode.add(removeVal + remove.left.val);
            }
            if (remove.right != null) {
                queNode.add(remove.right);
                queValNode.add(removeVal + remove.right.val);
            }
        }
        return false;
    }


    public static boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }


}