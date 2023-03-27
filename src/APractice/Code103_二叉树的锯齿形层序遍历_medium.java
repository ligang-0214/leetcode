package APractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/12 15:54
 */
public class Code103_二叉树的锯齿形层序遍历_medium {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        int flag = 1;
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.removeFirst();
                temp.add(node.val);
                if (node.left != null) {
                    linkedList.addLast(node.left);
                }
                if (node.right != null) {
                    linkedList.addLast(node.right);
                }
            }
            if (flag % 2 == 0) {
                Collections.reverse(temp);
            }
            flag++;
            res.add(temp);
        }
        return res;
    }

}
