package G二叉树;

/**
 * Author:松鼠
 * Date:2021/6/30 15:32
 */
public class Code98_验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        System.out.println(isValidBST1(head));
    }

    /**
     * 这个写的  觉得不太好
     */
    static long preValue = Long.MIN_VALUE;
    public static boolean isValidBST1(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean l = isValidBST1(root.left);
        if(!l || root.val <= preValue){
            return false;
        }else {
            preValue = root.val;
        }
        return isValidBST1(root.right);
    }


    /**
     * 这个是真的简洁  好清爽
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return  validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
