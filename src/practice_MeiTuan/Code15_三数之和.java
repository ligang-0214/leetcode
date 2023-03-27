package practice_MeiTuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/3/30 10:18
 */
public class Code15_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) {
                return res;
            }
//            if(i > 0 && nums[i] == nums[i-1] ){ //对a去重
//                continue;
//            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = a + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i+1]){ //我这样写也行的  对a去重
                i++;
            }
        }
        return res;
    }

}
