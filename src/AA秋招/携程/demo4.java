package AA秋招.携程;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/30 19:22
 */
public class demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int secMax = Integer.MIN_VALUE;
        int secIndex = -1;

        int flag = 0;
        for (int i = 1; i < n ; i++) {
            int temp = Math.abs(nums[i] - nums[i - 1]);
            if (temp > max ) {
                if(max != Integer.MIN_VALUE){
                    max = temp;
                    maxIndex = i;
                    secMax = max;
                    secIndex = maxIndex;
                }else {
                    max = temp;
                    maxIndex = i;
                }
            }else {
                if(temp > secMax){
                    secMax = temp;
                    secIndex = i;
                }
            }
        }

        if (secMax == Integer.MIN_VALUE) {
            System.out.println(max);
        } else {
            if (maxIndex == n - 1 || maxIndex == 1) {
                System.out.println(secMax);
            } else {
                int temp = (nums[maxIndex - 1] + nums[maxIndex + 1]) / 2;
                int res = Math.max(Math.max(Math.max(temp, nums[maxIndex - 1]), nums[maxIndex + 1]), secMax);
                System.out.println(res);
            }
        }
    }
}
