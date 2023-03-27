package APractice;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/7/10 11:49
 */
public class Code47_全排列二_medium {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, set);
        return res;
    }

    private void backtracking(int[] nums, HashSet<Integer> set) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !set.contains(i - 1))
                continue;
            set.add(i);
            temp.add(nums[i]);
            backtracking(nums, set);
            set.remove(i);
            temp.removeLast();
        }
    }

}
