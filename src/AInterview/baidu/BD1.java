package AInterview.baidu;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/22 18:42
 */
public class BD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] pre = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pre[i][j] = sc.nextInt();
            }
        }
        int cur = N * K;
        int[][] res = new int[cur][cur];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = pre[i][j];
                for (int m = 0; m < K; m++) {
                    for (int n = 0; n < K; n++) {
                        res[i * K + m][j * K + n] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < cur; i++) {
            for (int j = 0; j < cur; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
