package AA秋招.度小满;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 松鼠
 * @data 2022/8/31 19:40
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1){
            System.out.println(9);
        }else if(n== 2){
            System.out.println(80);
        }else if(n == 3){
            System.out.println(704);
        }
        long[] longs = new long[n];
        longs[0] = 9;
        longs[1] = 80;
        longs[2] = 704;
        for (int i = 3; i < n; i++) {
            longs[i] = (8 * longs[i- 1] + 64 * longs[i - 3]) % 1000000007;
        }
        System.out.println(longs[n - 1]);
    }
}
