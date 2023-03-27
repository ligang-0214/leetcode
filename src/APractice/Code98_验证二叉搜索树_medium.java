package APractice;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/7/12 16:49
 */
public class Code98_验证二叉搜索树_medium {

    // 中序遍历改的  DFS
    long pre = Long.MIN_VALUE;

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST1(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST1(root.right);
    }


    /**
     * --------------------------------------------------------------
     */


    // 迭代的方式  DFS
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if(pre >= pop.val){
                return false;
            }
            pre = pop.val;
            root = pop.right;
        }
        return true;
    }


}
