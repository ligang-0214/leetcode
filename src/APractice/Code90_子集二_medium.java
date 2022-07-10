package APractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/10 11:00
 */
public class Code90_子集二_medium {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        backtracking(nums , 0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        res.add(new ArrayList<>(temp));
        if(index >= nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            // 这个去重真的太好用了  比标记数组省空间
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            temp.add(nums[i]);
            backtracking(nums , i + 1);
            temp.removeLast();
        }
    }

}
