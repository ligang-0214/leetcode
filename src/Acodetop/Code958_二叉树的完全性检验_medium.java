package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/3/11 10:03
 */
public class Code958_二叉树的完全性检验_medium {

    //因为递归的过程中根本判断不了是不是完全二叉树，只有递归结束后nodeNum和num都收集完毕才能判断
    int nodeNum = 0, num = 0;
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root, 1);
        return nodeNum == num; //最后通过比较二叉树中的节点个数 是否和最后一个节点的位置号相同来判断
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        nodeNum++;//二叉树中节点数加1
        num = Math.max(num, k); //更新二叉树中位置最大的数
        dfs(root.left, 2 * k);//左子树的位置号
        dfs(root.right, 2 * k + 1); //右子树的位置号
    }

}
