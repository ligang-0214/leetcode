package Acodetop;

import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/2/26 9:38
 */
public class Code106_从中序与后序遍历序列构造二叉树_medium {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return process(postorder, 0, postorder.length - 1, 0, inorder.length - 1);


    }

    private TreeNode process(int[] postorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }

        int rootNum = postorder[postRight];
        Integer rootIndex = map.get(rootNum);
        TreeNode root = new TreeNode(rootNum);
        root.left = process(postorder, postLeft, postLeft + rootIndex - inLeft - 1,
                inLeft, rootIndex - 1);
        root.right = process(postorder, postLeft + rootIndex - inLeft, postRight - 1,
                rootIndex + 1, inRight);
        return root;
    }

}
