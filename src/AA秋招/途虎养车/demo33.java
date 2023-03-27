package AA秋招.途虎养车;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/9/7 19:59
 */
public class demo33 {
    public static void main(String[] args) {
        minVehiclePaintingCost(new int[][]{
                {4,8,6},
                {6,13,8},
                {1,2,3}
        });
        System.out.println(res);
    }

    static int res = Integer.MAX_VALUE;
    public static int minVehiclePaintingCost (int[][] costs) {
        // write code here
        int row = costs.length;
        int col = costs[0].length;
        boolean[][] chars = new boolean[row][col];
        backtracking(0 , chars , costs);
        return res;
    }

    private static void backtracking( int curRow, boolean[][] chars , int[][] costs) {
        if(curRow == costs.length){
            cal(chars , costs);
            return;
        }
        for (int col = 0; col < costs[0].length; col++) {
            if(isValid(curRow , col , chars , costs)){
                chars[curRow][col] = true;
                backtracking(curRow + 1 , chars , costs);
                chars[curRow][col] = false;
            }
        }
    }

    private static boolean isValid(int curRow, int curCol, boolean[][] chars, int[][] costs) {
        if(curRow - 1 >= 0 && chars[curRow - 1][curCol]){
            return false;
        }
        if(curRow + 1 < chars.length && chars[curRow + 1][curCol]){
            return false;
        }
        return true;
    }

    private static void cal(boolean[][] chars , int[][] costs) {
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if(chars[i][j]){
                    temp += costs[i][j];
                }
            }
        }
        res = Math.min(res , temp);
    }

}
