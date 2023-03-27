package AInterview.jd;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/19 18:41
 */
public class JD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int flag = 0;
        int temp = 0;
        while (a > 0) {
            flag++;//经过几轮
            int curSumXue = b * d + temp;
            //小七先打
            curSumXue -= a; //剩余的血
            if (curSumXue <= 0) {
                System.out.println(flag);
                return;
            }
            // 剩余的碉堡
            d = curSumXue / b ;
            temp = curSumXue % b;
            //对手反击
            a -= c * (d + 1); //小七剩余坦克
        }
        System.out.println(-1);
    }
}
