package AA秋招.科大讯飞;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/7/23 18:15
 */
public class KDXF1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 0) {
            System.out.print(0);
            return;
        }
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add((long) sc.nextInt());
        }
        for (int i = 0; i < list.size(); i++) {
            if(i != list.size() - 1){
                double v = (0.5 * (1 - Math.cos(2 * 3.1415927 * i / N))) * list.get(i);
                if (v > 0) {
                    System.out.print((int) (v + 0.5) + " ");
                } else if (v < 0) {
                    System.out.print((int) (v - 0.5) + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }else {
                double v = (0.5 * (1 - Math.cos(2 * 3.1415927 * (list.size() - 1) / N))) * list.get(list.size() - 1);
                if (v > 0) {
                    System.out.print((int) (v + 0.5) );
                } else if (v < 0) {
                    System.out.print((int) (v - 0.5) );
                } else {
                    System.out.print(0 );
                }
            }

        }

    }
}
