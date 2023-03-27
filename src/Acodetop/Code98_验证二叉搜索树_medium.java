package Acodetop;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/2/27 17:07
 */
public class Code98_验证二叉搜索树_medium {

    //递归的写法
    public boolean isValidBST1(TreeNode root) {
        return dfs1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs1(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return dfs1(root.left, minValue, root.val) && dfs1(root.right, root.val, maxValue);
    }

    //迭代的写法
    public boolean isValidBS2(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        long minValue = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
            if(node.val > minValue){
                minValue = node.val;
            }else {
                return false;
            }
        }
        return true;
    }


}
