package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 15:03
 */
public class Code62_不同路径_medium {

    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j-1];
            }
        }
        return res[n-1];
    }

}
