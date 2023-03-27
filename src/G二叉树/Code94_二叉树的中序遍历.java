package G二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author:松鼠
 * Date:2021/6/30 9:15
 */
public class Code94_二叉树的中序遍历 {
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
        List<Integer> list = inorderTraversal(head);
        System.out.println(list.toString());
        List<Integer> list1 = inorderTraversal1(head);
        System.out.println(list1.toString());
    }

    /**
     * 用递归实现中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        return process(list,root);
    }

    public static List<Integer> process(List<Integer> list,TreeNode root){
        if (root == null) {
            return list;
        }
        process(list,root.left);
        list.add(root.val);
        process(list,root.right);
        return list;
    }

    /**
     * 使用非递归方式实现中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        if(root == null){
            return new ArrayList<Integer>(){};
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode treeNode = stack.pop();
                list.add(treeNode.val);
                root = treeNode.right;
            }
        }
        return list;

    }


}
