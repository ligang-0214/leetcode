package Acodetop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/2/23 16:59
 */
public class Code94_二叉树的中序遍历_easy {

    //递归的方式
    public List<Integer> inorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        return process(root , res);
    }

    private List<Integer> process(TreeNode root, ArrayList<Integer> res) {
        if(root == null){
            return res;
        }

        process(root.left , res);
        res.add(root.val);
        process(root.right , res);
        return res;
    }


    //非递归的方式   自己维护一个栈
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = pop.right;
        }
        return res;


    }



}
