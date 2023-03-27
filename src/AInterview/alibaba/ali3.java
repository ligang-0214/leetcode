package AInterview.alibaba;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/25 10:23
 */
public class ali3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] lines = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                lines[i][j] = sc.nextInt();
            }
        }

        int[] temp = new int[n];
        int index = 0;
        for (int[] line : lines) {
            int k = -(line[0] / line[1]);
            temp[index++] = k;
        }
        int max = 0;
        int[] res = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if(temp[i] != temp[j]){

                ++res[i];
                }
            }
            max = Math.max(max , res[i]);
        }
        System.out.println(max);
    }
}
