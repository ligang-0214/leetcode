package APractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/7/10 20:21
 */
public class Code145_二叉树的后序遍历_easy {

    // 递归的方式
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        process1(root , res);
        return res;
    }

    private void process1(TreeNode root, List<Integer> res) {
        if(root == null)
            return;
        process1(root.left , res);
        process1(root.right , res);
        res.add(root.val);
    }

    /**
     * ---------------------------------------------------------------
     */

    // 前序遍历：中左右   后序遍历：左右中      把前序遍历的左右换一下位置  再将结果反转一下就成后序遍历了
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.left != null){
                stack.add(pop.left);
            }
            if(pop.right != null){
                stack.add(pop.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

}
