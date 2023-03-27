package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/27 16:19
 */
public class Code41_缺失的第一个正数_hard {

    //原地hash好巧妙    时间：O(N)   空间：O(1)
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 这个条件很容易写错  最好自己敲一下
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }

}
