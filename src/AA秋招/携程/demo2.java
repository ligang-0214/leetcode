package AA秋招.携程;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/30 19:16
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int y = sc.nextInt();
            int o = sc.nextInt();
            int u = sc.nextInt();
            int minNum = Math.min(Math.min(u, o), y);
            y -= minNum;
            o -= minNum;
            u -= minNum;
            int res = minNum * 2;
            if (o >= 2) {
                res += o - 1;
            }
            System.out.println(res);

        }
    }
}
