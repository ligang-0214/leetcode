package AA秋招.b站;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 松鼠
 * @data 2022/9/1 18:53
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int start = 2;
        int sqrtN = (int) Math.sqrt(n);
        while (true){
            if(start > sqrtN){
                break;
            }
            if(n % start == 0){
                sum += start;
                n = n / start;
                sqrtN = (int) Math.sqrt(n);
            }else {
                start++;
            }
        }
        System.out.println(sum + n);
    }
}
