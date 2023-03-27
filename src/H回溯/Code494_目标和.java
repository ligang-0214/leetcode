package H回溯;

/**
 * @author 松鼠
 * @data 2022/3/19 15:29
 */
public class Code494_目标和 {

    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backtracking(nums, 0, 0 ,target);
        return res;
    }

    private void backtracking(int[] nums, int sum, int curIndex , int target) {
        if (curIndex == nums.length) {
            if (target == sum) {
                res++;
            }
            return;
        }
        backtracking(nums, sum + nums[curIndex], curIndex + 1 , target);
        backtracking(nums, sum - nums[curIndex], curIndex + 1 , target);
    }
}
