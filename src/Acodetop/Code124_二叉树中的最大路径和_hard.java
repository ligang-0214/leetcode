package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/24 15:28
 */
public class Code124_二叉树中的最大路径和_hard {

    int max = Integer.MIN_VALUE;

    //这个题有点绕   可以多看看
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNum = Math.max(dfs(root.left) , 0);
        int rightNum = Math.max(dfs(root.right) , 0);
        max = Math.max(max , leftNum + rightNum + root.val);
        return root.val + Math.max(leftNum , rightNum);
    }

}
