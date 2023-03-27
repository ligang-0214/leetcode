package AInterview.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/12 16:04
 * 小美现在相信一些数字能给他带来好运。
 *
 * 这些数字至少满足以下两个特征中的一种：
 *
 * 1. 数字是11的整数倍。
 *
 * 2. 数字中至少包含两个1。
 *
 * 小美现在给你若干数字，希望你回答这个数字是不是幸运数。
 * 6
 * 22
 * 101
 * 1234
 * 555
 * 10001
 * 132
 * 例如：132是11的12倍，满足条件1，101有两个1，满足条件2。
 */
public class MeiTuan1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        String[] res = new String[sum];
        int[] nums = new int[sum];
        for (int i = 0; i < sum; i++) {
            nums[i] = sc.nextInt();
            System.out.println(checkOne(nums[i]) == true ? "yes" : "no");
        }
    }
    public static boolean checkOne(int num){
        if(num % 11 == 0){
            return true;
        }
        int count = 0;
        while (num != 0){
            if(num % 10 == 1){
                count++;
            }
            if(count == 2){
                return true;
            }
            num = num/10;
        }
        return false;
    }
}
