package APractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/7/12 14:09
 */
public class Code113_路经总和二_medium {


    // 递归的方式  DFS
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        temp.addLast(root.val);
        process(root, targetSum - root.val);
        return res;
    }

    private void process(TreeNode root, int sum) {
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (root.left != null) {
            temp.addLast(root.left.val);
            process(root.left, sum - root.left.val);
            temp.removeLast();
        }
        if (root.right != null) {
            temp.addLast(root.right.val);
            process(root.right, sum - root.right.val);
            temp.removeLast();
        }
    }


    /**
     * ----------------------------------------------------------------------------------
     */


    // 迭代的方式  DFS   【有点麻烦  就没实现】
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        return res;

    }

}
