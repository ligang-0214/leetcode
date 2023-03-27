package AInterview.baidu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/29 19:14
 */
public class JH1 {
//    static int res = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int temp = x;
        x = x > y ? x : y; // x为较大值
        y = x == temp ? y : temp;
        int res = 0;
        while (true){
            if(a >= b){
                a -= x;
                b -= y;
            }else {
                b -= x;
                a -= y;
            }
            if(a >= 0 && b >= 0){
                res++;
            }else
                break;
        }
        System.out.println(res);

//        process(a , b , x , y , 0);
//        System.out.println(res);
    }

//    private static void process(int a, int b, int x, int y, int temp) {
//        if(a < 0 || b < 0)
//            return;
//        if(a >= 0 && b >= 0 ){
//            res = Math.max(res , temp);
//        }
//        process(a - x , b - y , x , y , temp + 1);
//        process(a - y , b - x , x , y , temp + 1);
//    }
}
