package practice_MeiTuan;


import Acodetop.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/3/30 14:31
 */
public class Code94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null ){
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = pop.right;
        }
        return res;
    }

}
