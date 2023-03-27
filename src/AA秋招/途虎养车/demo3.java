package AA秋招.途虎养车;

/**
 * @author 松鼠
 * @data 2022/9/7 19:38
 */
public class demo3 {
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
        for (int i = 0; i < col; i++) {
            process(costs , 0 , col , costs[0][i]);
        }
        return res;
    }

    private static void process(int[][] costs, int row, int col , int cur) {
        if(row == costs.length - 1){
            res = Math.min(res , cur);
            return;
        }
        if(col- 1 >= 0){
            process(costs , row + 1 , col - 1 , cur + costs[row + 1][col - 1]);
        }
        if(col + 1 < costs[0].length){
            process(costs , row + 1 , col + 1 , cur + costs[row + 1][col + 1]);
        }
    }
}
