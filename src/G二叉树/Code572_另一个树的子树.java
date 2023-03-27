package G二叉树;

/**
 * Author:松鼠
 * Date:2021/7/3 19:09
 */
public class Code572_另一个树的子树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(4);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(2);
//        head.left.right.left = new TreeNode(0);
        head.right = new TreeNode(5);
        TreeNode head1 = new TreeNode(4);
        head1.left = new TreeNode(1);
        head1.right = new TreeNode(2);
        System.out.println("是否可以为另一棵树的子树："+ isSubtree(head,head1));


    }


//    static boolean flag = false;
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;
//        if(process(root,subRoot) == true){
//            flag = true;
//        }
//        isSubtree(root.left,subRoot);
//        isSubtree(root.right,subRoot);
//        return flag;
        return process(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static boolean process(TreeNode root, TreeNode subRoot){
//        if((root != null && subRoot == null)||(root == null && subRoot != null))
//            return false;
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        return process(root.left,subRoot.left) && process(root.right,subRoot.right);
    }
}
