package A数组;

/**
 * Author:松鼠
 * Date:2021/9/17 10:02
 */
public class Code59_螺旋矩阵二 {
    public static void main(String[] args) {
        int n = 3;
        int[][] res = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int up = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int flag = 0;
        while (true){
            for (int i = left ; i <= right ; i++) {
                res[up][i] = ++flag;
            }
            if(flag == n*n)
                break;
            up++;
            for (int i = up ; i <= down ; i++) {
                res[i][right] = ++flag;
            }
            if(flag == n*n)
                break;
            right--;
            for (int i = right; i >= left ; i--) {
                res[down][i] = ++flag;
            }
            if(flag == n*n)
                break;
            down--;
            for (int i = down; i >= up ; i--) {
                res[i][left] = ++flag;
            }
            if(flag == n*n)
                break;
            left++;
        }
        return res;
    }
}
