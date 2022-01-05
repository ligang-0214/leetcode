package H回溯;


/**
 * @author 松鼠
 * @data 2022/1/5 19:52
 */
public class Code79_单词搜索 {

    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean res = backtracking(board, word, i, j,visited,0);
                if(res)
                    return true;
            }
        }
        return false;

    }

    /**
     * 这个有点像之前什么 挖矿工  机器人走棋盘  之类的  看提交的效果还不错  就没看其他解法
     * @param board
     * @param word
     * @param i
     * @param j
     * @param visited
     * @param index
     * @return
     */
    private boolean backtracking(char[][] board, String word, int i, int j, boolean[][] visited, int index) {
        if(i >= board[0].length || i < 0 || j >= board.length || j <0 )
            return false;
        if(visited[i][j] == true) //有可能往回走或者走到了已经走过的地方 这里处理一下
            return false;
        if (board[i][j] != word.charAt(index)) { //如果不等于就false
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        if(backtracking(board,word,i-1,j,visited,index+1))
            return true;
        if(backtracking(board,word,i+1,j,visited,index+1))
            return true;
        if(backtracking(board,word,i,j-1,visited,index+1))
            return true;
        if(backtracking(board,word,i,j+1,visited,index+1))
            return true;

        visited[i][j] = false;
        return false;
    }

}
