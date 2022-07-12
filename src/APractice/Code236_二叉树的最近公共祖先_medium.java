package APractice;

/**
 * @author 松鼠
 * @data 2022/7/12 16:01
 */
public class Code236_二叉树的最近公共祖先_medium {

    // 没做出来  有点不好找到规律

    /**
     * 根据以上定义，若 rootroot 是 p ,q 的 最近公共祖先 ，则只可能为以下情况之一：
     * 1、p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
     * 2、p = root ，且 q 在 root 的左或右子树中；
     * 3、q = root ，且 p 在 root 的左或右子树中；
     */
    // https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
    // 题解非常好
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null && rightNode == null) {
            return null;
        } else if (leftNode != null && rightNode != null) {
            return root;
        } else {
            return leftNode != null ? leftNode : rightNode;
        }
    }

}
