package G二叉树;

/**
 * Author:松鼠
 * Date:2021/7/2 10:20
 */
public class Code110_平衡二叉树 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        System.out.println("是否为平衡二叉树："+isBalanced(head));
        System.out.println("是否为平衡二叉树："+isBalanced1(head));

    }

    /**
     * 方法真的好用！！！！！
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return process(root).isBalance;
    }
    public static class ReturnType{
        int height;
        boolean isBalance;
        public ReturnType(int height,boolean isBalance){
            this.height = height;
            this.isBalance = isBalance;
        }
    }
    public static ReturnType process(TreeNode root){
        if(root == null){
            return new ReturnType(0,true);
        }
        ReturnType l = process(root.left);
        ReturnType r = process(root.right);
        boolean isBalance = true;
        if(!l.isBalance || !r.isBalance || Math.abs(l.height - r.height) > 1){
            isBalance = false;
        }
        return new ReturnType(Math.max(l.height,r.height)+1,isBalance);
    }


    public static boolean isBalanced1(TreeNode root) {
        return process1(root) >= 0 ;
    }

    private static int process1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int l = process1(root.left);
        int r = process1(root.right);
        if(l == -1 || r == -1){
            return -1;
        }
        if(Math.abs(l-r)>1){
            return -1;
        }
        return Math.max(l,r) + 1;
    }
}
