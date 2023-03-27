package AA秋招.滴滴;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/9/4 19:59
 */
public class demo2 {
    HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            left.add(sc.nextInt());
        }
        for (int i = 0; i < T; i++) {
            right.add(sc.nextInt());
        }
        for (int i = 0; i < T; i++) {
            sums.add(sc.nextInt());
        }
        for (int i = 0; i < T; i++) {
            process(left.get(i) , right.get(i) , sums.get(i));
        }

    }

    private static void process(int left, int right, int sum) {
        int res = 0;
        for (int i = left ; i <= right; i++) {

            int temp = i % 10;
            int sum1 = i;
            sum1 /= 10;
            while (sum1 != 0){
                temp = temp ^ (sum1 % 10);
                sum1 = sum1 / 10;
            }
            if(temp == sum){
                res++;
            }
//            String s = String.valueOf(i);
//            int temp = 0;
//            for (int j = 0; j < s.length(); j++) {
//                temp ^= (s.charAt(j) -'0');
//            }
//            if(temp == sum){
//                res++;
//            }
        }
        System.out.print(res + " ");
    }

}
