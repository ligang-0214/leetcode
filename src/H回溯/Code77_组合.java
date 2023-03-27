package H回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2021/12/29 10:18
 */
public class Code77_组合 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return result;
    }

    private void backTracking(int n, int k, int startIndex) {
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1  ; i++) {
            path.addLast(i);
            backTracking(n,k,i+1);
            path.removeLast();
        }
    }
}
