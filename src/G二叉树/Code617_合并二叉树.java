package G二叉树;

/**
 * Author:松鼠
 * Date:2021/7/2 15:57
 */
@SuppressWarnings("all")
public class Code617_合并二叉树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.right.left = new TreeNode(7);
        TreeNode head1 = new TreeNode(5);
        head1.right = new TreeNode(8);
        head1.right.left = new TreeNode(7);
        head1.right.right = new TreeNode(10);
        Code_打印一个可视化的二叉树.printTree(mergeTrees(head,head1));
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return process(new TreeNode(0,null,null),root1,root2);
    }
    public static TreeNode process(TreeNode newHead,TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null){
            newHead.val = root2.val;
            newHead.left = process(new TreeNode(0,null,null),null,root2.left);
            newHead.right = process(new TreeNode(0,null,null),null,root2.right);
        }
        if(root2 == null){
            newHead.val = root1.val;
            newHead.left = process(new TreeNode(0,null,null),root1.left,null);
            newHead.right = process(new TreeNode(0,null,null),root1.right,null);
        }
        if (root1 != null && root2 != null){
            newHead.val = root1.val + root2.val;
            newHead.left = process(new TreeNode(0,null,null),root1.left,root2.left);
            newHead.right = process(new TreeNode(0,null,null),root1.right,root2.right);
        }
        return newHead;
    }

    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }


}
