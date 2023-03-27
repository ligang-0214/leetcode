package H回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2021/12/29 17:02
 */
public class Code40_组合总数二 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            //重要！！！！！  非常细节
            //与39题相比在这加了个处理  比如数据集： 1、1、2、5、6、7
            //不加的话就不能处理一些重复 1【第一个1】、2、5  1【第二个1】、2、5
            if(i > index && candidates[i] == candidates[i-1])
                continue;

            path.addLast(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i+1, sum); //这里和39题不一样  因为不可以重复使用了
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
