package AA秋招.蔚来;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/7/27 18:27
 */
public class WL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = sc.nextInt();
        }
        System.out.println(maxSubArray2(temp));
    }
    public static int maxSubArray2(int[] nums){
        int preSum = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums){
            preSum = Math.max(preSum + num , num);
            res = Math.max(preSum , res);
        }
        return res;
    }
}
