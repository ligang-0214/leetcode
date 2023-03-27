package AA秋招.顺丰;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/31 17:45
 */
public class demo11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        for (int i = 4; i <= num; i++) {
            list.add(1 + list.get(i/2 - 1));
        }
        for (Integer integer : list) {
            res += integer;
        }
        System.out.println(res);

    }
}
