package APractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/7/10 20:40
 */
public class Code94_二叉树的中序遍历_easy {

    // 非递归的方式
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
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
