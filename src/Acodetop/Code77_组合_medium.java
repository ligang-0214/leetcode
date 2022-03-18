package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/3/18 15:27
 */
public class Code77_组合_medium {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n ,1 , k);
        return res;
    }

    private void backtracking(int n,int cur, int k) {
        if(k == 0){
            res.add(new ArrayList<>(temp));
        }
        for (int i = cur; i <= n; i++) {
            temp.addLast(i);
            backtracking(n , i + 1 , k - 1);
            temp.removeLast();
        }
    }

}
