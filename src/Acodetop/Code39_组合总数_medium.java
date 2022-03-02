package Acodetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/3/2 10:56
 */
public class Code39_组合总数_medium {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    int flag = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates , target , 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if(flag == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(flag > target){
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if(candidates[i] > target)
                return;
            flag += candidates[i];
            temp.addLast(candidates[i]);
            backtracking(candidates , target , i);
            flag -= candidates[i];
            temp.removeLast();
        }
    }

}
