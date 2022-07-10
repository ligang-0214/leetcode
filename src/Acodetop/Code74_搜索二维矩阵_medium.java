package Acodetop;

/**
 * @author 松鼠
 * @data 2022/6/27 9:38
 */
public class Code74_搜索二维矩阵_medium {

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            if ((right - left) == 1)
                break;
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (matrix[left][0] == target || matrix[right][0] == target)
            return true;
        // 主要就是这一句  你要找到准确的那一行
        int row = target > matrix[right][0] ? right : left;
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
