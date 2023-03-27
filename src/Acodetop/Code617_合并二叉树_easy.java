package Acodetop;

/**
 * @author 松鼠
 * @data 2022/7/12 16:43
 */
public class Code617_合并二叉树_easy {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return process(root1, root2);
    }

    private TreeNode process(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
            root.left = process(root1.left, root2.left);
            root.right = process(root1.right, root2.right);
        } else if (root1 != null) {
            root.val = root1.val;
            root.left = process(root1.left, null);
            root.right = process(root1.right, null);
        } else {
            root.val = root2.val;
            root.left = process(root2.left, null);
            root.right = process(root2.right, null);
        }
        return root;
    }

}
