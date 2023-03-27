package ANowCoder;

/**
 * @author 松鼠
 * @data 2022/3/18 20:08
 */
public class BM61_矩阵最长递增路径_medium {

    int res = 0;
    public int solve (int[][] matrix) {
        // write code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(matrix , i , j , -1 , 0);
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int row, int col , int pre , int temp) {
        //这里 matrix[row][col] <= pre 要加个等于号  因为也有可能往回走   但是这里有个局限  就是矩阵中的值互不相同
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= pre){
            return;
        }
        temp++;
        res = Math.max(res , temp);
        dfs(matrix , row + 1 , col , matrix[row][col] , temp);
        dfs(matrix , row - 1 , col , matrix[row][col] , temp);
        dfs(matrix , row , col + 1 , matrix[row][col] , temp);
        dfs(matrix , row , col -1 , matrix[row][col] , temp);
    }


}
