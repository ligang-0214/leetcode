package AA秋招.网易;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 14:47
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int[] arr = new int[N];
        System.arraycopy(nums , 0 , arr , 0 , N);
        int count1 = 0;
        int count2 = 0;
        for (int i = 1; i < N; i++) {
            if(i % 2 != 0 && arr[i] >= arr[i-1]){
                count1 += arr[i] - arr[i - 1] + 1;
                arr[i] = arr[i - 1] + 1;
            }else if(i % 2 == 0 && arr[i] <= arr[i - 1]){
                count1 += arr[i - 1] - arr[i] + 1;
            }
        }
        for (int i = 1; i < N; i++) {
            if(i % 2 != 0 && nums[i] <= nums[i-1]){
                count2 += nums[i - 1] - nums[i] + 1;
            }else if(i % 2 == 0 && nums[i] >= nums[i - 1]){
                count2 += nums[i] - nums[i - 1] + 1;
                nums[i] = nums[i - 1] - 1;
            }
        }
        System.out.println(Math.min(count1 , count2));
    }
}
