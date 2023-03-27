package AA秋招.美团;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/8/20 11:35
 */
public class demo5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            a = Math.max(arr1[i] , a);
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
            b = Math.max(arr2[i] , b);
        }
        if(a > b){
            System.out.println(-1);
            return;
        }
        HashMap<Integer , Integer> map = new HashMap<>();
        Arrays.sort(arr2);
        for (int i = 0; i < m; i++) {
            map.put(arr2[i] , i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(arr1[i])){
                res += arr2[map.get(arr1[i])];
            }else {
                int val = def(arr2 , arr1[i]);
                map.put(arr1[i] ,val);
                res += arr2[val];
            }

        }
        System.out.println(res);
    }

    private static int def(int[] arr, int flag) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > flag){
                return i;
            }
        }
        return -1;
    }
}
