package practice_MeiTuan;

import Acodetop.TreeNode;

/**
 * @author 松鼠
 * @data 2022/3/29 21:25
 */
public class Code124_二叉树中的最大路径和 {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        process(root);
        return res;
    }

    private int process(TreeNode root) {
        if(root == null)
            return 0;
        int left =  Math.max(process(root.left) , 0);
        int right =  Math.max(process(root.right) , 0);
        res = Math.max(left + right + root.val , res);
        return Math.max(root.val + left, root.val + right);
    }

}
