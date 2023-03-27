package Acodetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/24 10:54
 */
public class Code199_二叉树的右视图_medium {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        System.out.println(rightSideView(head).toString());

    }


    public static List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        int flag = 0;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.removeFirst();
                if (flag == 0) {
                    list.add(node.val);
                    flag = 1;
                }

                if (node.right != null) {
                    linkedList.addLast(node.right);
                }
                if (node.left != null) {
                    linkedList.addLast(node.left);
                }
            }
            flag = 0;
        }
        return list;
    }

}
