package AInterview.wyLeiHuo;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/26 13:56
 */
public class leihuo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int res = 0;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
                if((i != (x -1)) || (j != (y - 1))){
                    res += nums[i][j];
                }
            }
        }
        System.out.println(res+1);

    }
}
