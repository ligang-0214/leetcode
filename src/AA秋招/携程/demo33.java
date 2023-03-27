package AA秋招.携程;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/30 20:42
 */
public class demo33 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nextInt = new Random().nextInt(2);
        if (nextInt == 0) {

            System.out.println("1");
        }else {
            System.out.println("10");
        }
    }
}
