package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 14:45
 */
public class Code226_翻转二叉树_easy {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
