package G二叉树;

/**
 * Author:松鼠
 * Date:2021/7/3 15:51
 */
public class Code437_路径总和三 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.left.left = new TreeNode(3);
        head.left.right = new TreeNode(2);
        head.left.left.left = new TreeNode(3);
        head.left.left.right = new TreeNode(-2);
        head.right = new TreeNode(-3);
        head.right.right = new TreeNode(11);
        head.left.right = new TreeNode(2);
        head.left.right.right = new TreeNode(1);
//        Code_打印一个可视化的二叉树.printTree(head);
        System.out.println(pathSum(head,8));

    }

    static int flag = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        hasPathSum1(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return flag;
    }

    public static void hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return ;
        }
        if (sum == root.val){
            flag++;
        }
        hasPathSum1(root.left, sum - root.val);
        hasPathSum1(root.right, sum - root.val);
    }
}
