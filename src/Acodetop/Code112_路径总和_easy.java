package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/1 15:36
 */
public class Code112_路径总和_easy {

    int temp = 0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root , targetSum );
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        temp += root.val;
        if(root.left == null && root.right == null){
            if(temp == targetSum){
                temp -= root.val;
                return true;
            }else {
                temp -= root.val;
                return false;
            }
        }
        boolean l = hasPathSum(root.left , targetSum);
        boolean r = hasPathSum(root.right , targetSum);
        temp -= root.val;
        return l || r;
    }


}
