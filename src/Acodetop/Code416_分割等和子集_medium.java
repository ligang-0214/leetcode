package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/19 10:39
 */
public class Code416_分割等和子集_medium {

    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }
        int flag = sum / 2;
        int[] dp = new int[flag + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = flag; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j] , dp[j - nums[i]] + nums[i]);
            }
        }
        //最后看一下集合中的元素是否正好可以拼凑出flag
        return dp[flag] == flag;
    }

}
