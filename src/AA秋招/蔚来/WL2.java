package AA秋招.蔚来;


import Acodetop.TreeNode;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/7/27 19:04
 */
public class WL2 {
    static class TreeNode {
        public int val;
        public int index;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val, int index) {
            this.val = val;
            this.index = index;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] values = new int[N];
        int[] index = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            index[i] = sc.nextInt();
        }

        TreeNode root = new TreeNode();
        for (int i = 0; i < N; i++) {
            if (index[i] == 0) {
                root.val = values[i];
                root.index = i + 1;
                break;
            }
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = linkedList.removeFirst();
                int flag = 0;
                for (int j = 0; j < N; j++) {
                    if (index[j] == treeNode.index) {
                        if (flag == 0) {
                            TreeNode leftNode = new TreeNode(values[j], j + 1);
                            treeNode.left = leftNode;
                            flag = 1;
                            linkedList.addLast(leftNode);
                            continue;
                        }
                        if (flag == 1) {
                            TreeNode rightNode = new TreeNode(values[j], j + 1);
                            treeNode.right = rightNode;
                            linkedList.addLast(rightNode);
                        }
                    }
                }
            }
        }

        System.out.println(maxPathSum(root));
    }

    static int res = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        process(root);
        return res;
    }

    private static int process(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(process(root.left), 0);
        int right = Math.max(process(root.right), 0);
        res = Math.max(left + right + root.val, res);
        return Math.max(root.val + left, root.val + right);
    }

}
