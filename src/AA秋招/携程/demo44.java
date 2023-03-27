package AA秋招.携程;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/30 20:27
 */
public class demo44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = Math.abs(nums[0] - nums[1]);
        int left = 0;
        int right = 1;
        for (int i = 2; i < n; i++) {
            if(Math.abs(nums[i] - nums[i - 1]) > max){
                max = Math.abs(nums[i] - nums[i - 1]);
                left = i - 1;
                right = i;
            }
        }
        if (left == 0) {
            nums[left]= nums[right];
            System.out.println(maxval(nums));
        }else {
            if(right == n - 1){
                nums[right] = nums[right - 1];
                System.out.println(maxval(nums));
            }else {
                int leftvv = nums[left - 1];
                int rightv = nums[right];
                int leftv = (rightv - leftvv) / 2 +leftvv;
                int temp = nums[left];
                nums[left] = leftv;
                int c1 = maxval(nums);
                nums[left] = temp;
                int temp1 = nums[right];
                int rightvv = nums[right + 1];
                int rightvvv = (rightvv - temp) / 2 + temp;
                nums[right] = rightvvv;
                int c2 = maxval(nums);
                System.out.println(Math.min(c1 , c2));
            }
        }
    }

    private static int maxval(int[] nums) {
        int maxval = Math.abs(nums[0] - nums[1]);
        int left = 0;
        int right = 1;
        for (int i = 2; i < nums.length; i++) {
            if(Math.abs(nums[i] - nums[i - 1]) > maxval){
                maxval = Math.abs(nums[i] - nums[i - 1]);
                left = i - 1;
                right = i;
            }
        }
        return maxval;

    }
}
