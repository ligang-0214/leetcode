package APractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/10 11:41
 */
public class Code46_全排列_medium {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtracking(nums, new int[nums.length]);
        return res;
    }

    private void backtracking(int[] nums, int[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            temp.add(nums[i]);
            backtracking(nums, used);
            used[i] = 0;
            temp.removeLast();
        }
    }

}
