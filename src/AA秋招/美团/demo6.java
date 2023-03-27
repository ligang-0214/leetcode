package AA秋招.美团;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 11:48
 */
public class demo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] index = new int[3][2];
        for (int i = 0; i < 3; i++) {
            index[i][0] = sc.nextInt();
            index[i][1] = sc.nextInt();
        }
        int[] ints = new int[3];
        for (int i = 0; i < 3; i++) {
            ints[i] = sc.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (process(index, ints, i, j)) {
                    System.out.print(i + " ");
                    System.out.println(j);
                    return;
                }
            }

        }

    }

    private static boolean process(int[][] index, int[] s, int i, int j) {
        if (Math.abs(index[0][0] - i) + Math.abs(index[0][1] - j) == s[0] &&
                Math.abs(index[1][0] - i) + Math.abs(index[1][1] - j) == s[1] &&
                Math.abs(index[2][0] - i) + Math.abs(index[2][1] - j)  == s[2]
        ) {
            return true;
        }
        return false;
    }
}
