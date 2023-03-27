package AA秋招.海信;

import java.util.ArrayList;

/**
 * @author 松鼠
 * @data 2022/9/15 19:30
 */
public class demo2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> getMatrix(int[][] matrix) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] % 2 == 1) {
                    list.add(matrix[i][j] * 2);
                } else {
                    list.add(matrix[i][j]);
                }
            }
            res.add(list);
        }
        return res;
    }

}
