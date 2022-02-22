package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/22 8:55
 */
public class Code102_二叉树的层序遍历_medium {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        linkedList.add(root);
        TreeNode curEndNode = root;
        TreeNode nextEndNode = null;

        while (!linkedList.isEmpty()) {

            TreeNode node = linkedList.removeFirst();
            list.add(node.val);

            if (node.left != null) {
                linkedList.addLast(node.left);
                nextEndNode = node.left;
            }
            if (node.right != null) {
                linkedList.addLast(node.right);
                nextEndNode = node.right;
            }
            if (node == curEndNode) {
                res.add(list);
                curEndNode = nextEndNode;
                list = new ArrayList<>();
            }
        }
        return res;
    }

}
