package APractice;

/**
 * @author 松鼠
 * @data 2022/7/30 10:20
 */
public class Code53_最大子数组和_easy {

    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int preMax = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(preMax <= 0){
                preMax = nums[i];
            }else {
                preMax += nums[i];
            }
            res = Math.max(res , preMax);
        }
        return res;
    }

}
