package AA秋招.度小满;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/31 18:59
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int temp1 = nums[i];
            int temp2 = nums[i];
            if (temp1 / temp2 == k && temp1 % temp2 == 0) {
                res++;
            }
            for (int j = i + 1; j < n; j++) {
                temp1 = Math.max(temp1, nums[j]);
                temp2 = Math.min(temp2, nums[j]);
                if (temp1 / temp2 == k && temp1 % temp2 == 0) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
