package Acodetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/21 16:42
 */
public class Code15_三数之和_medium {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 1、nums[i] 就是 a
            if(nums[i] > 0){ //如果当前循环的开始就大于0  那肯定不可能又符合结果的情况
                return res;
            }
            if(i > 0 && nums[i] == nums[i-1] ){
                continue;
            }
            // 2、nums[left] 就是 b
            int left = i + 1;
            // 3、nums[right] 就是 c
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
