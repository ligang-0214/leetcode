package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/27 15:26
 */
public class Code113_路经总和二_medium {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(7);
        head.left = new TreeNode(0);
        head.left.left = new TreeNode(-1);
        head.left.right = new TreeNode(-6);
        head.left.left.right = new TreeNode(1);
        head.left.left.right.left = new TreeNode(-7);
        pathSum(head , 0);
    }



    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> temp = new LinkedList<>();
    static int tempSum = 0;

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        dfs(root, targetSum);
        return res;
    }

    private static void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return ;
        }
        temp.addLast(root.val);
        tempSum += root.val;
        if(root.left == null && root.right == null){
            if(tempSum == targetSum){
                res.add(new ArrayList<>(temp));
            }
        }
        dfs(root.left , targetSum);
        dfs(root.right , targetSum);
        temp.removeLast();
        tempSum -= root.val;
    }

}
