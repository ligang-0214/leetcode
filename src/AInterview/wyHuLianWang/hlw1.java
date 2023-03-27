package AInterview.wyHuLianWang;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/27 15:01
 */
public class hlw1 {
//    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int a1 = a;
        int b1 = b;
        int res1 = 0;
        int res2 = 0;
        while (a > 0){
            a -= x;
            res1++;
        }
        while (b > 0){
            b -= x;
            res1++;
        }
        while (a1 > 0 && b1 > 0){
            a1 -= y;
            b1 -= y;
            res2++;
        }
        while (a1 > 0){
            a1 -= x;
            res2++;
        }
        while (b1 > 0){
            b1 -= x;
            res2++;
        }
        System.out.println(Math.min(res1 , res2));

    }

//    private static void process(int a, int b, int x, int y, int temp) {
//        if(a <= 0 && b <= 0){
//            res = Math.min(res , temp);
//            return;
//        }
//        if(a <= 0){
//            process(a , b - x , x ,y , temp+1);
//            process(a , b - y , x , y, temp+1);
//        }else if(b <= 0){
//            process(a -x, b , x ,y , temp+1);
//            process(a - y, b, x , y, temp+1);
//        }else {
//            process(a -x, b , x ,y , temp+1);
//            process(a , b - x, x ,y , temp+1);
//            process(a - y, b- y, x ,y , temp+1);
//        }
//    }
}
