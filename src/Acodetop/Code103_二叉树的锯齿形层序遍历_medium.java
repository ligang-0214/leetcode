package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/22 9:57
 */
public class Code103_二叉树的锯齿形层序遍历_medium {

    //这道题看似特别简单   但是我卡了很久
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        linkedList.add(root);
        int flag = 1;
        while (!linkedList.isEmpty()){
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.removeFirst();
                if(flag % 2 == 1){
                    list.addLast(node.val);
                }else {
                    list.addFirst(node.val);
                }
                if(node.left != null){
                    linkedList.addLast(node.left);
                }
                if(node.right != null){
                    linkedList.addLast(node.right);
                }
            }
            res.add(list);
            list = new LinkedList<>();
            flag++;
        }
        return res;


    }

}
