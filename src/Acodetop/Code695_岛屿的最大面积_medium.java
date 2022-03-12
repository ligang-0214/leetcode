package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/11 8:59
 */
public class Code695_岛屿的最大面积_medium {

    int res = 0;
    int temp = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    res = Math.max(res , temp);
                    temp = 0;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if(i<0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == 1){
            temp++;
            grid[i][j] = 0;
            dfs(grid, i-1,j);
            dfs(grid, i+1,j);
            dfs(grid, i,j-1);
            dfs(grid, i,j+1);
        }else {
            return;
        }
    }

}
