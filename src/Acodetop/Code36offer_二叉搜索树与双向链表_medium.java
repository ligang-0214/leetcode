package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/11 9:51
 */
public class Code36offer_二叉搜索树与双向链表_medium {

    //https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
    TreeNode pre = null;
    TreeNode head = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null){
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(TreeNode cur) {
        if(cur == null){
            return;
        }
        // 再中序遍历的基础上改的
        dfs(cur.left); //先遍历左子树
        if(pre == null){ //然后按照题目修改之间的关系
            head = cur;
        }else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right); //然后遍历右子树
    }

}
