package Acodetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/2/24 9:16
 */
public class Code144_二叉树的前序遍历_easy {

    public List<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        return process(root , res);

    }

    private List<Integer> process(TreeNode root, ArrayList<Integer> res) {
        if(root == null){
            return res;
        }

        res.add(root.val);
        process(root.left , res);
        process(root.right , res);
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
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
