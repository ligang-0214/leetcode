package AA秋招.奇虎360;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/27 15:11
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.next().toCharArray();
        char[] str2 = sc.next().toCharArray();
        if(str1.length != str2.length){
            return;
        }
        LinkedList<Integer> listA1 = new LinkedList<>();
        LinkedList<Integer> listT1 = new LinkedList<>();
        LinkedList<Integer> listA2 = new LinkedList<>();
        LinkedList<Integer> listT2 = new LinkedList<>();
        for (int i = 0; i < str1.length; i++) {
            if(str1[i] == 'A'){
                listA1.addLast(i);
            }else {
                listT1.addLast(i);
            }
            if(str2[i] == 'A'){
                listA2.addLast(i);
            }else {
                listT2.addLast(i);
            }
        }
//        if(listA1.size() > listA2.size()){
//            listT1.addLast(listA1.removeFirst());
//            listT1.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1 - o2;
//                }
//            });
//        }else if(listA1.size() < listA2.size()){
//            listT2.addLast(listA2.removeFirst());
//            listT2.sort(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1 - o2;
//                }
//            });
//        }

        int res = process(str1 , str2);
        System.out.println(res);
        int i = listA1.size() - listA2.size() > 0 ? listA1.size() - listA2.size() : listA2.size() - listA1.size();
        System.out.println((res - i) / 2 + i) ;





    }

    private static int process(char[] str1, char[] str2) {
        int len = str1.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int j = 1; j <= len; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i <= len; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                int left = dp[i -1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i -1][j - 1];
                if(str1[i - 1] == str2[j - 1]){
//                    dp[i][j] = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(left , Math.min(down , left_down));
                }else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[len][len];
    }
}
