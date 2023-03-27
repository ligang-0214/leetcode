package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 10:14
 */
public class Code48_旋转图像_medium {
    public static void main(String[] args) {
        int[][] a = {
                {1,2,3},
                {1,2,3},
                {7,8,9}
        };
        rotate(a);
    }

    //线性代数的内容  先水平翻转  再对角翻转
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
