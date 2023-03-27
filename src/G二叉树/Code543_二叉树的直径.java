package G二叉树;

/**
 * Author:松鼠
 * Date:2021/7/2 11:06
 */
public class Code543_二叉树的直径 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        System.out.println("二叉树的直径:"+diameterOfBinaryTree(head));
    }

    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        process(root);
        return max;
    }
    public static int process(TreeNode x){
        if (x == null){
            return 0;
        }
        int l = process(x.left);
        int r = process(x.right);
        max = Math.max(l + r ,max);
        return Math.max(l , r) + 1;
    }
}
