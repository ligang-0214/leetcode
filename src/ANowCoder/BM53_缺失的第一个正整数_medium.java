package ANowCoder;

/**
 * @author 松鼠
 * @data 2022/6/23 14:28
 */
public class BM53_缺失的第一个正整数_medium {

    // 原地hash法   时间：O(N)   空间：O(1)
    public int minNumberDisappeared (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // nums[i] != i + 1  表示自己所在的位置不对
            // nums[nums[i] - 1] != nums[i]  表示自己要去的位置没有被同伴占有  如果不写的话 示例[1,1]就会一直循环
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                swap(nums , i , nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
