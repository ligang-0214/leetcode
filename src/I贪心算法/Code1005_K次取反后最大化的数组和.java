package I贪心算法;

import java.util.Arrays;

/**
 * @author 松鼠
 * @data 2022/1/7 9:27
 */
public class Code1005_K次取反后最大化的数组和 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0 || k == 0){
                break;
            }
            nums[i] = -nums[i];
            k--;
        }

        if(k > 0){
            k = k % 2;
            Arrays.sort(nums);
            for (int i = 0; i < k; i++) {
                nums[i] = -nums[i];
            }
        }

        int res = 0;
        for (int num : nums) {
            res += num;
        }

        return res;
    }

}
