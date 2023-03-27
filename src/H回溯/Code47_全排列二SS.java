package H回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/1/5 15:58
 */
public class Code47_全排列二SS {

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] flag ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        flag = new boolean[nums.length];
        Arrays.fill(flag, false);
        Arrays.sort(nums);
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if(path.size() == nums.length){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i] && flag[i-1] == false)
                continue;
            if(flag[i] == false){
                flag[i] = true;
                path.add(nums[i]);
                backtracking(nums);
                flag[i] = false;
                path.removeLast();
            }
        }
    }

}
