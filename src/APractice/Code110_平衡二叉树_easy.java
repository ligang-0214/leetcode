package APractice;

import org.omg.CORBA.MARSHAL;

/**
 * @author 松鼠
 * @data 2022/7/11 20:50
 */
public class Code110_平衡二叉树_easy {

    // 递归的方式  DFS
    public boolean isBalanced1(TreeNode root) {
        return process1(root) != -1 ;
    }

    private int process1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = process1(root.left);
        int right = process1(root.right);
        if(Math.abs(left - right) > 1){
            return -1;
        }
        if(left == -1 || right == -1){
            return -1;
        }
        return Math.max(left , right) + 1;
    }



    // 迭代的方式  BFS
    public boolean isBalanced2(TreeNode root) {
        // carl写了一个版本  虽然不复杂但是代码比较多  懒得写
        return true;
    }




}
