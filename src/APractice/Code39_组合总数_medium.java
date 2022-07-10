package APractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/9 21:03
 */
public class Code39_组合总数_medium {

    //这题简单就简单在 candidates 中的元素不重复
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || candidates[0] > target) {
            return res;
        }
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target)
            return;

        for (int i = index; i < candidates.length; i++) {
            //在这里加个剪枝操作能快不少
            if(sum + candidates[i] > target)
                break;
            temp.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i);
            temp.removeLast();
        }
    }

}
