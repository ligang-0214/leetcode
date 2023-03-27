package AA秋招.携程;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/30 19:03
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            process(num);
        }
    }

    private static void process(int num) {
        if(num % 2 == 0){
            System.out.println(num);
        }else {
            char[] chars = (num + "").toCharArray();
            int len = chars.length;
            for (int i = len - 1; i >= 0 ; i--) {
                if((chars[i] - 48) % 2 == 0 || ((chars[i] - 48) == 0) ){
                    char temp = chars[i];
                    chars[i] = chars[len - 1];
                    chars[len - 1] = temp;
                    System.out.println(Integer.parseInt(new String(chars)));
                    return;
                }
            }
            System.out.println(-1);
        }
    }
}
