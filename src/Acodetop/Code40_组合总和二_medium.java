package Acodetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/3/18 16:09
 */
public class Code40_组合总和二_medium {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if(candidates[0] > target){
            return res;
        }
        backtracking(candidates , target , 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int curIndex) {
        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target)
            return;
        for (int i = curIndex; i < candidates.length; i++) {
            sum += candidates[i];
            temp.addLast(candidates[i]);
            backtracking(candidates , target , i+1);
            sum -= candidates[i];
            temp.removeLast();
            while ( i + 1 < candidates.length && candidates[i] == candidates[i+1])
                i++;
        }
    }

}
