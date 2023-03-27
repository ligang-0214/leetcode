package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/26 9:29
 */
public class Code108_将有序数组转换为二叉搜索树_easy {

    public TreeNode sortedArrayToBST(int[] nums) {

        return process(nums , 0 , nums.length -1);
    }

    private TreeNode process(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2; //每次选择中间位置 或者 中间位置的左边作为根节点
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums , left , mid -1);
        root.right = process(nums , mid + 1 , right);
        return root;
    }

}
