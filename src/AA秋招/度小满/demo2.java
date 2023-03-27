package AA秋招.度小满;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/31 19:10
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = sc.nextInt();
        while (flag-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            int[][] nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            if(process(nums ,0 , 0 , n , m , k , x,0) == false){
                System.out.println("no");
            }
        }
    }

    private static boolean process(int[][] nums, int row, int col, int n, int m, int k, int target , int cur) {
        if(row == n - 1 && col == m - 1){
            if(cur == target){
                System.out.println("yes");
                return true;
            }else {
                return false;
            }
        }
        if(row + 1 < n){
            boolean p1 = process(nums, row + 1, col, n, m, k, target, cur + nums[row][col]);
            if(p1 ){
                return true;
            }
        }
        if(col + 1 < m){
            boolean p2 = process(nums, row, col + 1, n, m, k, target, cur + nums[row][col]);
            if(p2 ){
                return true;
            }
        }
        return false;
    }

}
