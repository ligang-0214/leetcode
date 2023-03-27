package AInterview.gld;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/4/13 19:50
 */
public class gld1 {
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        process(nums, 0, 0, 0 , 0);
        System.out.println(res);
    }

    private static void process(int[][] nums, int red, int green, int index , int flag) {
        if (index >= nums.length){
            res = Math.max(res , flag);
            return;
        }
        int temp1 = nums[index][0] * red + nums[index][1] * green;
        int temp2 = nums[index][2] * red + nums[index][3] * green;
        process(nums, red + 1, green, index + 1 , flag + temp1);
        process(nums, red, green + 1, index + 1 , flag + temp2);
    }
}
