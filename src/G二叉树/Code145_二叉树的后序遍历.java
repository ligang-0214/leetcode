package G二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Author:松鼠
 * Date:2021/6/30 9:50
 */
@SuppressWarnings("all")
public class Code145_二叉树的后序遍历 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        List<Integer> list = postorderTraversal(head);
        List<Integer> list1 = postorderTraversal1(head);
        System.out.println(list.toString());
        System.out.println(list1.toString());
    }

    /**
     * 递归的方式实现后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        return process(list,root);
    }
    public static List<Integer> process(List<Integer> list,TreeNode root){
        if (root == null) {
            return list;
        }
        process(list,root.left);
        process(list,root.right);
        list.add(root.val);
        return list;
    }


    /**
     * 非递归的方式实现后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}
