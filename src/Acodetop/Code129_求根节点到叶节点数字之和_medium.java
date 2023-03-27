package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/26 16:36
 */
public class Code129_求根节点到叶节点数字之和_medium {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(9);
        head.right = new TreeNode(0);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(1);
        sumNumbers(head);

    }

    static int res = 0;
    static int temp = 0;
    public static int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        temp = temp*10 + root.val;
        if(root.left == null && root.right == null){
            res += temp;
            temp /= 10;
            return res;
        }
        if(root.left != null){
            sumNumbers(root.left);
        }
        if(root.right != null){
            sumNumbers(root.right);
        }
        temp /= 10;
        return res;
    }

}
