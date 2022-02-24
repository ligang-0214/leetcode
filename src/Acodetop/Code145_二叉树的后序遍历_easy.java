package Acodetop;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/24 9:58
 */
public class Code145_二叉树的后序遍历_easy {

    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        return process(list,root);
    }
    public static List<Integer> process(List<Integer> list, TreeNode root){
        if (root == null) {
            return list;
        }
        process(list,root.left);
        process(list,root.right);
        list.add(root.val);
        return list;
    }

}
