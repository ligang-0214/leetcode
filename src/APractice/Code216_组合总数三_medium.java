package APractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/9 20:21
 */
public class Code216_组合总数三_medium {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return res;
    }

    private void backtracking(int k, int n, int sum, int index) {
        if (sum > n || temp.size() > k) {
            return;
        }
        if (sum == n && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < 10; i++) {
            temp.addLast(i);
            backtracking(k, n, sum + i, i + 1);
            temp.removeLast();
        }
    }

}
