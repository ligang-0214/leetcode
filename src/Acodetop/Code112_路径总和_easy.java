package Acodetop;


/**
 * @author 松鼠
 * @data 2022/3/1 15:36
 */
public class Code112_路径总和_easy {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return process(root, targetSum - root.val);
    }

    private boolean process(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                return true;
            } else {
                return false;
            }
        }
        if (root.left != null) {
            if (process(root.left, targetSum - root.left.val)) {
                return true;
            }
        }
        if (root.right != null) {
            if (process(root.right, targetSum - root.right.val)) {
                return true;
            }
        }
        return false;
    }








}
