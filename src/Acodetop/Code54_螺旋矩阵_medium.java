package Acodetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/23 15:05
 */
public class Code54_螺旋矩阵_medium {

    //正儿八经模拟旋转的过程
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null){
            return res;
        }
        int up = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int left = 0;
        int num = matrix.length * matrix[0].length;

        while (num > 0){
            for (int i = left; i <= right && num > 0; i++) {
                res.add(matrix[up][i]);
                num--;
            }
            up++;
            for (int i = up; i <= down && num > 0; i++) {
                res.add(matrix[i][right]);
                num--;
            }
            right--;
            for (int i = right; i >= left && num > 0; i--) {
                res.add(matrix[down][i]);
                num--;
            }
            down--;
            for (int i = down; i >= up && num > 0; i--) {
                res.add(matrix[i][left]);
                num--;
            }
            left++;
        }
        return res;
    }
}
