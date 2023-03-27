package AA秋招.网易;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 16:05
 */
public class demo22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < N; i++) {
            if(i % 2 == 0){
                max1 = Math.max(max1 , arr[i]);
                res1.add(arr[i]);
            }else {
                max2 = Math.max(max2 , arr[i]);
                res2.add(arr[i]);
            }

        }
        long res = 0;
        for (int i = 0; i < res1.size(); i++) {
            res += max1 - res1.get(i);
        }
        for (int i = 0; i < res2.size(); i++) {
            res += max2 - res2.get(i);
        }
        if(max1 == max2){
            res += Math.min(res1.size() , res2.size());
        }
        System.out.println(res);
    }
}
