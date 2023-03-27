package AA秋招.天翼云;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/9/14 20:54
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] split = sc.next().split(",");
        Integer[] nums = new Integer[N];
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.valueOf(split[i]);
            if (nums[i] % 2 == 0) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (Integer integer : list1) {
            buffer.append(integer + ",");
        }
        for (Integer integer : list2) {
            buffer.append(integer + ",");
        }
        System.out.println(buffer.toString().substring(0, buffer.length() - 1));
    }

}
