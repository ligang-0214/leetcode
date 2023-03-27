package AA秋招.网易;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 16:22
 */
public class demo44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            if (map.containsKey(arr[i])) {
                k = map.get(arr[i]);
            }

            while (j < k) {
                if (arr[k] != arr[i]) {
                    k--;
                    continue;
                }
                if (arr[k] == arr[i]) {
                    if (!map.containsKey(arr[i])) {
                        map.put(arr[i], k);
                    }
                }

                for (int m = j; m < k; m++) {
                    if (arr[i] > arr[m]) {
                        res++;
                    }
                }
                k--;
            }
        }
        System.out.println(res);
    }
}
