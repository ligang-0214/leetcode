package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/22 10:44
 */
public class Code236_二叉树的最近公共祖先_medium {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if(leftNode == null && rightNode == null){
            return null;
        }else if(leftNode == null){
            return rightNode;
        }else if(rightNode == null){
            return leftNode;
        }else {
            return root;
        }
    }

}
