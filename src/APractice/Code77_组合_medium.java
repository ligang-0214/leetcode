package APractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/9 19:55
 */
public class Code77_组合_medium {


    //剪枝！剪枝！剪枝！
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, 1, k);
        return res;
    }

    private void backtracking(int n, int index, int k) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            backtracking(n, i + 1, k);
            temp.removeLast();
        }
    }

}
