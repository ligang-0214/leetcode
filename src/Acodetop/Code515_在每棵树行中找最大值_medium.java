package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/11 10:15
 */
public class Code515_在每棵树行中找最大值_medium {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root == null) {
            return res;
        }
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.removeFirst();
                max = Math.max(max , node.val);
                if (node.left != null) {
                    linkedList.addLast(node.left);
                }
                if (node.right != null) {
                    linkedList.addLast(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

}
