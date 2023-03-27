package APractice;

import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/7/12 10:30
 */
public class Code112_路径总和_easy {

    // 递归的解法  DFS
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


    /**
     * -------------------------------------------------------------------------------
     */


    //迭代的解法 DFS  【这个使用双栈记录值真的很好用 和257一个路子】
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> curSum = new Stack<>();
        stack.add(root);
        curSum.add(root.val);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            Integer cur = curSum.pop();
            if (pop.left == null && pop.right == null && cur == targetSum) {
                return true;
            }
            if (pop.right != null) {
                stack.add(pop.right);
                curSum.add(cur + pop.right.val);
            }
            if (pop.left != null) {
                stack.add(pop.left);
                curSum.add(cur + pop.left.val);
            }
        }
        return false;
    }


}
