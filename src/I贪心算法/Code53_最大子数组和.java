package I贪心算法;

/**
 * @author 松鼠
 * @data 2022/1/6 16:26
 */
public class Code53_最大子数组和 {

    //贪心处理
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int res = nums[0];
        int preMaxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(preMaxSum <= 0){
                preMaxSum = nums[i];
            }else {
                preMaxSum += nums[i];
            }
            if(res < preMaxSum)
                res = preMaxSum;
        }
        return res;
    }

    //DP处理  一开始就想用DP做  但是我想复杂了
    public int maxSubArrayDP(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
