package H回溯;

import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2021/12/29 16:27
 */
public class Code39_组合总和 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if(candidates[0] > target)
            return result;
        backtracking(candidates,target,0,0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int index, int sum) {
        if(sum > target)
            return;
        if(sum == target){
            result.add(new LinkedList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            //在这里加个剪枝操作
            if(sum + candidates[i] > target)
                break;
            path.addLast(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i, sum); //题目说元素可以重复使用  所以就不需要 i+1
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
