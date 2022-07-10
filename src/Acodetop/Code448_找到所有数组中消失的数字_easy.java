package Acodetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/4 9:37
 */
public class Code448_找到所有数组中消失的数字_easy {

    //原地哈希法
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }

}
