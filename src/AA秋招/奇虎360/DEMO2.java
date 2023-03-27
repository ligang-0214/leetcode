package AA秋招.奇虎360;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/27 15:55
 */
public class DEMO2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = 0;
        while (t != 0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            n = 0;
            if(a >c){
                n = n + c;
                a = a -c;
                c = 0;

            }else {
                n = n +a ;
                c = c -a;
                a = 0;
            }
            int ab = a /2;
            if(ab > b){
                n = n + b;
                a = a - ab * 2;
                b = 0;
            }else {
                n = n + ab + (b - ab ) / 2;
                b = (b - ab) % 2;
                a = 0;
            }
            int aa = a /4;
            n = n +aa;
            a = a - aa * 4;
            n = n +d;
            System.out.println(n);
            t--;
        }
    }
}
