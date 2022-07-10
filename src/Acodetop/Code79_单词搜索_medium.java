package Acodetop;

/**
 * @author 松鼠
 * @data 2022/7/10 15:09
 */
public class Code79_单词搜索_medium {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtracking(int row, int col, char[][] board, String word, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] < 'A') {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        } else {
            if (index == word.length() - 1)
                return true;
        }

        // 使用原始数组进行标记  节省空间【但是提交之后好像并没有省空间...】
        // 这个 -65  还是比较特殊的    A:65   a:97  z:122
        board[row][col] -= 65;
        if (backtracking(row + 1, col, board, word, index + 1)) {
            return true;
        }

        if (backtracking(row - 1, col, board, word, index + 1)) {
            return true;
        }
        if (backtracking(row, col + 1, board, word, index + 1)) {
            return true;
        }
        if (backtracking(row, col - 1, board, word, index + 1)) {
            return true;
        }
        board[row][col] += 65;

        return false;
    }

}
