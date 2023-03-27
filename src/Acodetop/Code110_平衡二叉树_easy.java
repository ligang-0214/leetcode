package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/26 17:07
 */
public class Code110_平衡二叉树_easy {

    public boolean isBalanced(TreeNode root) {
        return  process(root) != -1;
    }

    private int process(TreeNode root) {
        if(root == null){
            return 0;
        }
        int L = process(root.left);
        int R = process(root.right);
        if(L == -1 || R == -1){
            return -1;
        }
        if(Math.abs(L - R) > 1){
            return -1;
        }
        return Math.max(L , R) + 1;
    }

}
