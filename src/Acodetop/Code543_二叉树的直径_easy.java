package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/28 8:47
 */
public class Code543_二叉树的直径_easy {

    int res = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res-1;
    }

    private Integer dfs(TreeNode root) {
        if(root ==null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res , left + right + 1);
        return 1 + Math.max(left , right);
    }

}
