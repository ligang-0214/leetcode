package G二叉树;



/**
 * Author:松鼠
 * Date:2021/6/24 19:07
 */
public class Code_打印一个可视化的二叉树 {
    /**
     * 对外使用的api
     * @param head
     */
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:============================================================");
        printInOrder(head, 0, "H", 17);
        System.out.println("========================================================================");
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }
    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
