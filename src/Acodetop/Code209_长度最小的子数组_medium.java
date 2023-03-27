package Acodetop;

/**
 * @author 松鼠
 * @data 2022/6/27 11:32
 */
public class Code209_长度最小的子数组_medium {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            if (sum >= target) {
                while (sum - nums[left] >= target) {
                    sum -= nums[left++];
                }
                res = Math.min(res, right - left + 1);
            }
            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;

    }
}