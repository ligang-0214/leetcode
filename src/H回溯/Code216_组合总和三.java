package H回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2021/12/29 15:02
 */
public class Code216_组合总和三 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1,0);
        return result;
    }

    /**
     * 这题剪枝的操作有很多写法  但是无所谓了  提交之后都是0毫秒
     * @param k
     * @param n
     * @param startIndex
     * @param sum
     */
    private void backtracking(int k, int n, int startIndex,int sum) {
        if(sum > n)
            return;

        if(path.size() == k){
            if(sum == n){
                result.add(new LinkedList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 ; i++) {
            path.addLast(i);
            sum += i;
            backtracking(k,n,i+1,sum);
            Integer remove = path.removeLast();
            sum -= remove;
        }
    }
}
