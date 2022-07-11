package Acodetop;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/3/2 14:45
 */
public class Code226_翻转二叉树_easy {

    // 递归实现  DFS
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }


    /**
     * ------------------------------------
     */

    // 迭代实现BFS
    public TreeNode invertTree2(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root == null) {
            return root;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.removeFirst();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                if (node.left != null) {
                    linkedList.addLast(node.left);
                }
                if (node.right != null) {
                    linkedList.addLast(node.right);
                }
            }
        }
        return root;
    }


    //迭代实现DFS   【就相当于自己模拟栈  像是先序遍历】
    public TreeNode invertTree3(TreeNode root) {
        if(root == null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;

            if(pop.right != null){
                stack.add(pop.right);
            }
            if(pop.left != null){
                stack.add(pop.left);
            }
        }
        return root;
    }


}
