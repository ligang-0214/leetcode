package APractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/10 10:50
 */
public class Code78_子集_medium {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        backtracking(nums , 0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        res.add(new ArrayList<>(temp));
        if(index >= nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums , i + 1);
            temp.removeLast();
        }
    }

}
