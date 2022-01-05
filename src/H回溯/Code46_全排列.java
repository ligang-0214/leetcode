package H回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/1/5 15:28
 */
public class Code46_全排列 {

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果

    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {

        if(path.size() == nums.length){
            result.add(new LinkedList<>(path));
            return;
        }
        //这里验证重复数字之前是使用一个数组  这里为了简单  直接调用集合的contains方法
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])){
                path.add(nums[i]);
                backtracking(nums);
                path.removeLast();
            }
        }
    }

}
