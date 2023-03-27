package AInterview.alibaba;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/25 8:29
 */
public class ali2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Integer[][] nums = new Integer[t][5];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 5; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        for (Integer[] num : nums) {
            Arrays.sort(num , Collections.reverseOrder());
            int res = 0;
            while (num[3] > 0){
                for (int i = 0; i < 4; i++) {
                    --num[i];
                }
                ++res;
                Arrays.sort(num , Collections.reverseOrder());
            }
            System.out.println(res);
        }
    }

}
