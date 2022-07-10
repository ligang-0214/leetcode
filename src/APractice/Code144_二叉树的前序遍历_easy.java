package APractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/7/10 20:09
 */
public class Code144_二叉树的前序遍历_easy {

    // 递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        process1(root, res);
        return res;
    }

    private void process1(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        process1(root.left, res);
        process1(root.right, res);
    }

    /**
     * ---------------------------------------------------------------
     */

    // 迭代的方式
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        return res;
    }




}
