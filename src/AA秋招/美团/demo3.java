package AA秋招.美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 10:39
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[] gl = new double[n];
        double[] score = new double[n];
        for (int i = 0; i < n; i++) {
            gl[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }
        double res = 0;
        for (int i = 0; i < n; i++) {
            res += gl[i]/ 100 * score[i];
        }
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (100 - gl[i]) * score[i] /100;
        }
        Arrays.sort(arr);
        for (int i = n - 1; i > n - m; i--) {
            res += arr[i];
        }
        System.out.println(String.format("%.2f" , res));


    }
}
