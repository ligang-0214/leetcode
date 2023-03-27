package G二叉树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:松鼠
 * Date:2021/6/30 10:14
 */
@SuppressWarnings("all")
public class Code101_对称二叉树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.right.left = new TreeNode(4);
        head.right.right = new TreeNode(2);
        System.out.println(isSymmetric(head));
    }

    /**
     * 使用递归的方式来实现
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return process(root.left,root.right);
    }
    public  static boolean process(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val)
            return false;
        return process(t1.left,t2.right) && process(t1.right,t2.left);
    }


    /**
     * 使用迭代的方式来实现
     * 首先引入一个队列，这是把递归程序改写成迭代程序的常用方法。
     * 初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），
     * 然后将左结点的右孩子和右节点的左孩子一起放进队列中，左节点的左孩子和右节点的右孩子一起放进队列中。
     * 当队列为空时，或者我们检测到树不对称时，该算法结束。
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        if (root == null){
            return true;
        }
        return process1(root,root);
    }
    public static boolean process1(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(u);
        q.add(v);
        while (!q.isEmpty()) {
            u = q.remove();
            v = q.remove();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.add(u.left);
            q.add(v.right);

            q.add(u.right);
            q.add(v.left);
        }
        return true;
    }
}
