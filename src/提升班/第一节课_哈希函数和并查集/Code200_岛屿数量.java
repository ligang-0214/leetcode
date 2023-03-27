package 提升班.第一节课_哈希函数和并查集;

/**
 * Author:松鼠
 * Date:2021/8/27 15:36
 */
@SuppressWarnings("all")
public class Code200_岛屿数量 {
    //使用并查集的方式来实现
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 1;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] >= rank[rooty]) {
                    parent[rooty] = rootx;
                    rank[rootx] += rank[rooty];
                } else {
                    parent[rootx] = rooty;
                    rank[rooty] += rank[rootx];
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }



    //使用DFS的方式来实现
    public int numIslands1(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    process(grid,i,j);
                }
            }
        }
        return res;
    }

    public void process(char[][] grid , int i ,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] != '1')
            return ;
        grid[i][j] = 2;
        process(grid,i-1,j);
        process(grid,i+1,j);
        process(grid,i,j-1);
        process(grid,i,j+1);
    }
}
