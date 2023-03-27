package AA秋招.途虎养车;

import Acodetop.TreeNode;

/**
 * @author 松鼠
 * @data 2022/9/7 19:53
 */
public class demo2 {

    public int sum (TreeNode root) {
        // write code here
        return process(root , 2 , 2);

    }

    private int process(TreeNode root, int temp1, int temp2) {
        if(root == null){
            return  0;
        }
        int i = temp2 % 2 != 0 ? root.val : 0;
        return process(root.left , root.val , temp1) + process(root.right , root.val , temp1) + i;

    }

}
