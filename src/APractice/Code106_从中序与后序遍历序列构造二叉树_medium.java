package APractice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 松鼠
 * @data 2022/7/12 15:16
 */
public class Code106_从中序与后序遍历序列构造二叉树_medium {


    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 注意：区间一定要确定好  我的是 左闭右闭区间
        return process(postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode process(int[] postorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postRight]);
        int inIndex = map.get(postorder[postRight]);
        root.left = process(postorder, postLeft, postLeft + inIndex - inLeft - 1,
                inLeft, inIndex - 1);
        root.right = process(postorder, postLeft + inIndex - inLeft, postRight - 1,
                inIndex + 1, inRight);
        return root;
    }

}
