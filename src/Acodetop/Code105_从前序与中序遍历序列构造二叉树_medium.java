package Acodetop;

import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/2/25 16:23
 */
public class Code105_从前序与中序遍历序列构造二叉树_medium {

    //面试的时候 可以自己画个树   然后把前序和中序的遍历结果写出来
    //然后再做计算  会更直观方便一些

    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i] , i);
        }
        return buildTree(preorder , 0 , preorder.length - 1 , 0 , inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }

        int rootNodeNum= preorder[preLeft];
        TreeNode root = new TreeNode(rootNodeNum);
        Integer rootNodeIndex = map.get(rootNodeNum);

        root.left = buildTree(preorder , preLeft + 1 , preLeft + rootNodeIndex - inLeft ,
                inLeft , rootNodeIndex - 1);
        root.right = buildTree(preorder , preLeft + rootNodeIndex - inLeft + 1 , preRight,
                rootNodeIndex + 1 , inRight);
        return root;
    }

}
