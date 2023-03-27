package AA秋招.天翼云;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/9/14 20:22
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[][] nums = new Integer[N][2];
        for (int i = 0; i < N; i++) {
            String next = sc.next();
            String[] split = next.split(",");
            nums[i][0] = Integer.valueOf(split[0]);
            nums[i][1] = Integer.valueOf(split[1]);
        }
        Arrays.sort(nums, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        if (N == 1) {
            System.out.println(nums[0][1] - nums[0][0]);
            return;
        }
        int[] dp = new int[1000000];
        for (int i = 0; i < N; i++) {
            for (int j = nums[i][0] + 1; j <= nums[i][1]; j++) {
                dp[j]++;
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                res++;
            }
        }
        System.out.println(res);


    }
}
