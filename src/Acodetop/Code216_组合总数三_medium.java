package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/3/18 15:35
 */
public class Code216_组合总数三_medium {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(((1 + k) * k )/2 > n){
            return res;
        }
        backtracking(k , n ,1);
        return res;
    }

    private void backtracking(int k, int n, int cur) {
        if(sum == n && temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum > n)
            return;
        for (int i = cur; i <= 9; i++) {
            sum += i;
            temp.addLast(i);
            backtracking(k , n , i + 1);
            sum -= i;
            temp.removeLast();
        }
    }


}
