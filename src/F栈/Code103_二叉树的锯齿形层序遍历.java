package F栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2021/12/23 10:23
 */
public class Code103_二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {

    }


    /**
     * 使用两个栈来处理这个问题【我看答案都是在遍历的过程来处理，我这里只是为了练习栈的使用思想】
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> leftToRight = new Stack<>(); //存储二叉树中1、3、5、7、9.....行的节点
        Stack<TreeNode> rightToLeft = new Stack<>(); //存储二叉树中2、4、6、8、10.....行的节点
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        leftToRight.add(root);
        int flag = 1;
        while (!leftToRight.isEmpty() || !rightToLeft.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            if(flag % 2 == 1){
                while (!leftToRight.isEmpty()){ //一直把这一行的节点都弹出来
                    TreeNode pop = leftToRight.pop();
                    tmp.add(pop.val);
                    if(pop.left != null)
                        rightToLeft.add(pop.left); //由于栈的特性和题目要求，先存左节点  再存右节点
                    if(pop.right != null)
                        rightToLeft.add(pop.right);
                }
            }else {
                while (!rightToLeft.isEmpty()){
                    TreeNode pop = rightToLeft.pop();
                    tmp.add(pop.val);
                    if(pop.right != null)
                        leftToRight.add(pop.right);
                    if(pop.left != null)
                        leftToRight.add(pop.left);
                }
            }
            flag++;
            res.add(tmp);
        }
        return res;
    }
}
