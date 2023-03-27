package AA秋招.顺丰;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/31 16:40
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long temp = num;
        long res = 1;
        int flag = 2;
        for (int i = 2; i <= num; i++) {
            res += flag;
            if(i % 2 == 1){
                flag++;
            }
        }
        System.out.println(res);
//        long res = 0;
        res = 0;
        while (num > 0){
            double ceil = Math.ceil((num + 1) / 2.0);
//            System.out.println(ceil);
            res += ceil;
            num--;

        }
        System.out.println(res);

        res = 1;
        for (int i = 2; i <= temp; i++) {
            res += (i / 2) + 1;
        }
        System.out.println(res);



    }
}
