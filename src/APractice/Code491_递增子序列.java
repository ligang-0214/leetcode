package APractice;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/7/10 11:14
 */
public class Code491_递增子序列 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
        }
        if (index >= nums.length) {
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            // 这题还真不能用这个方式去重  因为nums不是有序的  例如4、6、7、7、7、8、7、7 就会出错
//            if (i > index && nums[i] == nums[i - 1] ) {
//                continue;
//            }

            if ((!temp.isEmpty() && nums[i] < temp.getLast()) || set.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            set.add(nums[i]);
            backtracking(nums, i + 1);
            temp.removeLast();
        }
    }


}
