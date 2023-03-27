package Acodetop;

import sun.awt.geom.AreaOp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/7/11 21:04
 */
public class Code257_二叉树的所有路径_easy {

    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths1(TreeNode root) {
        process(root, root.val + "");
        return res;
    }

    private void process(TreeNode root, String str) {
        if (root.left == null && root.right == null) {
            res.add(str.substring(0, str.length() - 2));
            return;
        }
        if (root.left != null) {
            process(root.left, str + root.left.val + "->");
        }
        if (root.right != null) {
            process(root.right, str + root.right.val + "->");
        }
    }


    /**
     * -------------------------------------------------------------------
     */


    // 迭代的方式  BFS  【有点绕  也可能是因为我晚上脑子转不动了  没写出来】
    public List<String> binaryTreePaths2(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        Stack<Object> stack = new Stack<>();

        StringBuffer stringBuffer = new StringBuffer();
        if (root == null) {
            return res;
        }
        stack.add(root);
        stack.add(root.val + "");
        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode pop = (TreeNode) stack.pop();

            if (pop.left == null && pop.right == null) {
                res.add(path);
                continue;
            }
            if (pop.right != null) {
                stack.add(pop.right);
                stack.add(path + "->" + pop.right.val);
            }
            if (pop.left != null) {
                stack.add(pop.left);
                stack.add(path + "->" + pop.left.val);
            }
        }
        return res;
    }


}
