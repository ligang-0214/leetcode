package AA秋招.滴滴;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/9/4 19:26
 */
public class demo1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] weight = new Integer[n];
        double sum = 0d;
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
            sum += weight[i];
        }
        Arrays.sort(weight, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = n - 1; i >= 0; i--) {
            if(weight[i] <= (sum / (float)(i + 1)) * k){
                System.out.println(i + 1);
                return;
            }else {
                sum -= weight[i];
            }
        }
    }
}
