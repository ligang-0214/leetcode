package H回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:松鼠
 * Date:2021/7/20 10:33
 */
@SuppressWarnings("all")
public class Code51_N皇后 {

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(8);
        System.out.println(lists.size());
        for (List<String> cur : lists) {
            System.out.println(cur);
        }
    }

    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return null;
        }
        int[] record = new int[n]; //用一维数组代替二维数组  record[i]=j 表示第i行的第j列为皇后
        backTracking(0, record, n);
        return res;
    }


    public static void backTracking(int row, int[] record, int n) {
        if (row == n) {
            res.add(generateBoard(record,n)); //生成答案所要的字符串
            return ;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(record, row, col)) { //判断（i,j）位置是否可以放皇后
                record[row] = col; //注意这里  下面回溯完之后不需要修改record[i]的值  因为没必要。。
                backTracking(row + 1, record, n); //行数加1  接着往下遍历
            }
        }
    }

    public static boolean isValid(int[] record, int row, int col) {
        for (int  i= 0; i < row; i++) {
            //这个判断条件超级简洁  非常好  仔细理解一下
            if (col == record[i] || Math.abs(record[i] - col) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
