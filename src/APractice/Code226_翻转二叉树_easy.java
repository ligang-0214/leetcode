package APractice;

/**
 * @author 松鼠
 * @data 2022/7/11 17:37
 */
public class Code226_翻转二叉树_easy {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
