package AInterview.wyLeiHuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/26 16:04
 */
public class leihuo4 {
    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();
        int W = sc.nextInt();
        int[][] nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        process(X - 1, Y - 1, Z - 1, W - 1, nums[X - 1][Y - 1], nums);
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(res.get(0));
    }

    private static void process(int curRow, int curCol, int tarRow, int tarCol, int num, int[][] nums) {
        if (curRow < 0 || curRow >= nums.length || curCol < 0 || curCol >= nums[0].length) {
            return;
        }
        if (curRow == tarRow && curCol == tarCol) {
            res.add(num);
            return;
        }
        num = Math.max(num, nums[curRow][curCol]);
        process(curRow + 1, curCol, tarRow, tarCol, num, nums);
        process(curRow - 1, curCol, tarRow, tarCol, num, nums);
        process(curRow, curCol - 1, tarRow, tarCol, num, nums);
        process(curRow, curCol + 1, tarRow, tarCol, num, nums);
    }
}
