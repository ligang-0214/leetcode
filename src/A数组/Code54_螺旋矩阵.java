package A数组;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:松鼠
 * Date:2021/9/16 19:43
 */
public class Code54_螺旋矩阵 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(arr).toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null)
            return list;
        //初始化 下、右边界的时候一定想明白
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;
        //初始化的不一样  那么循环的判断就不一样  真的是小细节
        while (true){
            for (int i = left; i <= right ; i++) {
                list.add(matrix[left][i]);
            }
            if(++up > down)break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if(--right < left)break;
            for (int i = right; i >= left ; i--) {
                list.add(matrix[down][i]);
            }
            if(--down < up)break;
            for (int i = down; i >= up ; i--) {
                list.add(matrix[i][left]);
            }
            if(++left > right)break;
        }
        return list;
    }

}
