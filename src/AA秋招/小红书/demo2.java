package AA秋招.小红书;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/28 17:23
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(process(nums , k));
    }

    private static int process(int[] nums, long k) {
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            long pow = (long) nums[i] * nums[j];
            if(pow >= k){
                res += (j - i) * 2;
                j--;
            }else {
                i++;
            }
        }
        return res;
    }
}
