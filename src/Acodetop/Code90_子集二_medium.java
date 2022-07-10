package Acodetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/28 17:40
 */
public class Code90_子集二_medium {

    // 处理重复有点小技巧
    // 我在 APractice 包下面写的解法是不需要标记数组的  直接判断  简直太好用了和40题一样处理的
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums, 0);
        return res;

    }

    private void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(temp));
        if(startIndex == nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            temp.addLast(nums[i]);
            used[i] = true;
            backtracking(nums , i+1);
            used[i] = false;
            temp.removeLast();
        }
    }

}
