package G二叉树;

/**
 * Author:松鼠
 * Date:2021/7/2 15:12
 */
public class Code226_反转二叉树 {
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
        Code_打印一个可视化的二叉树.printTree(head);
        Code_打印一个可视化的二叉树.printTree(invertTree(head));
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;
        invertTree(root.left);
        invertTree(root.right);
        return root;
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
    }
}
