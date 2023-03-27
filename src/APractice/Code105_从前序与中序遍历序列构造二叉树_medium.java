package APractice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 松鼠
 * @data 2022/7/12 14:38
 */
public class Code105_从前序与中序遍历序列构造二叉树_medium {

    // 确实是做的不熟   思路大概有个模模糊糊   但是没写出来
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 注意：区间一定要确定好  我的是 左闭右闭区间
        return process(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode process(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]); //先序的第一个节点就是当前这棵树的根节点
        int inIndex = map.get(preorder[preLeft]); //根节点在中序遍历中的位置
        root.left = process(preorder, preLeft + 1, preLeft + inIndex - inLeft,
                inLeft, inIndex - 1);
        root.right = process(preorder, preLeft + inIndex - inLeft + 1, preRight,
                inIndex + 1, inRight);

        return root;

    }

}
