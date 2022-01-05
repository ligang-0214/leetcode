package H回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/1/5 10:34
 */
public class Code78_子集 {

    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {
        //遍历这个树的时候，把所有节点都记录下来，这里跟组合、切割的处理不太一样
        result.add(new ArrayList<>(path));

        if(startIndex == nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            //由于路径上的答案都是所需要的  所以并没有剪枝的操作

            path.add(nums[i]);
            backtracking(nums,i + 1);
            path.removeLast();
        }
    }

}
