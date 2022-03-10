package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/10 15:37
 */
public class Code240_搜索二维矩阵_medium {

    //这个解法好秒   我脑子里闪了一下右上角  但是没往上想  只想能不能从中心二分去了
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
