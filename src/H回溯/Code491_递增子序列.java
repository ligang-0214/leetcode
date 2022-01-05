package H回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/1/5 15:11
 */
public class Code491_递增子序列 {

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] flag ;

    public List<List<Integer>> findSubsequences(int[] nums) {
        flag = new boolean[nums.length];
        backtracking(nums,0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        if(path.size() >= 2)
            result.add(new LinkedList<>(path));
        if(startIndex == nums.length)
            return;

        for (int i = startIndex; i < nums.length; i++) {
            if(i > 0){
                if(nums[i] < nums[i-1]) //剪枝操作
                    continue;
                if(nums[i] == nums[i-1] && flag[i-1] == false) //去重操作
                    continue;
            }
            path.add(nums[i]);
            flag[i] = true;
            backtracking(nums,i+1);
            path.removeLast();
            flag[i] = false;
        }
    }
}
