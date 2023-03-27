package AA秋招.美团;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 10:05
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        for (int i = 0; i < len; i++) {
            System.out.print(s1.charAt(i));
            System.out.print(s2.charAt(i));
        }
    }
}
