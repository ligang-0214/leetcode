package AA秋招.大疆;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/7 16:35
 */
public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (!s.isEmpty()){
            String[] split = s.split(" ");
            int start = Integer.valueOf(split[0]);
            int end = Integer.valueOf(split[1]);
            int flag = 0;
            for (int i = start; i <= end; i++) {
                ArrayList<Integer> list = process(i);
                int sum = 0;
                for (Integer integer : list) {
                    sum += Math.pow(integer , 3);
                }
                if(sum == i){
                    flag = 1;
                    System.out.print(i + " ");
                }
            }
            if(flag == 0) {
                System.out.print("no");
            }
            System.out.println();
            s = sc.nextLine();
        }
    }

    private static ArrayList<Integer> process(int i) {
        ArrayList<Integer> res = new ArrayList<>();
        int temp = i;
        while (temp > 0){
            res.add(temp % 10);
            temp = temp / 10;
        }
        return res;

    }
}
