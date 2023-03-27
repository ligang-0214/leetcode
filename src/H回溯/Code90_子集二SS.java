package H回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/1/5 14:16
 */
public class Code90_子集二SS {


    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] flag ;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        flag = new boolean[nums.length];
        backtracking(nums,0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        result.add(new LinkedList<>(path));
        if(startIndex == nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            //重要的部分就在这  处理重复元素  跟40题有一点点相似
            if(i > 0 && nums[i] == nums[i-1] && flag[i-1] == false){
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
