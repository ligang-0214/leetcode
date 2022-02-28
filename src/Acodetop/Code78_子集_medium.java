package Acodetop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/28 16:26
 */
public class Code78_子集_medium {

    //回溯类的题就背模板  多刷就好了
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(temp));
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            temp.addLast(nums[i]);
            backtracking(nums, i + 1);
            temp.removeLast();
        }
    }

}
