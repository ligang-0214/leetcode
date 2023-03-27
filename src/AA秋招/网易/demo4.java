package AA秋招.网易;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 15:26
 */
public class demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> used = new ArrayList<>(); //已使用
        ArrayList<Integer> noused = new ArrayList<>(); //待使用
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = sc.nextInt();
            if(i == 0){
                used.add(arr[i + 1]);
            }else {
                noused.add(arr[i + 1]);
            }
        }
        Collections.sort(noused);
        long res = 0L;
        for (int i = 1; i <= n; i++) {
            int minId = upper_bound(used , arr[i]);
            int maxId = lower_bound(noused , arr[i]);
            long count1 = minId;
            long count2 = noused.size() - maxId - 1;
            res += count1 * count2;
            used.add(minId , arr[i]);
            noused.remove(maxId);
        }

        System.out.println(res);
    }

    private static int lower_bound(ArrayList<Integer> noused, int tar) {
        int left = 0;
        int right = noused.size() - 1;
        int res = right + 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(noused.get(mid) > tar){
                right = mid - 1;
                res = mid;
            }else {
                left = mid + 1;
            }
        }
        return res;

    }

    private static int upper_bound(ArrayList<Integer> used, int tar) {
        int left = 0;
        int right = used.size() - 1;
        int res = right + 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if(used.get(mid) >= tar){
                right = mid - 1;
                res = mid;
            }else {
                left = mid + 1;
            }
        }
        return res;

    }
}
