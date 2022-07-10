package APractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/9 21:16
 */
public class Code40_组合总和二_medium {

    //这个去重真的没想到   不过可以想到使用标记数组来判断重复
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || candidates[0] > target) {
            return res;
        }
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int index, int sum) {
        if (sum > target)
            return;
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //和39题一样 这里先剪枝
            if (sum + candidates[i] > target)
                break;
            //这里的去重可以多思考一下 很巧妙  不像之前 i > 0 这种判断就可行
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            temp.add(candidates[i]);
            backtracking(candidates, target, i + 1, sum + candidates[i]);
            temp.removeLast();

            //这个和上面的去重效果一样
//            while( i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
//                i++;
//            }
        }
    }

}
