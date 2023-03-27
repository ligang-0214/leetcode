package AA秋招.微众银行;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/9/13 21:25
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            long temp1 = sc.nextLong();
            long temp2 = sc.nextLong();
            if(temp1 == temp2){
                System.out.println(0);
                continue;
            }
            long maxVal = Math.max(temp1 , temp2);
            long minVal = Math.min(temp1 , temp2);
            char[] charsA = Long.toBinaryString(maxVal).toCharArray();
            char[] charsB = Long.toBinaryString(minVal).toCharArray();
            int lengthA = charsA.length;
            int lengthB = charsB.length;
            int flag = 1;
            for (int j = 0; j < charsB.length; j++) {
                if(charsA[j] != charsB[j]){
                    System.out.println(-1);
                    flag = 0;
                    break;
                }
            }
            if(flag == 0){
                continue;
            }
            for (int j = lengthB; j < charsA.length; j++) {
                if(charsA[j] != '0'){
                    System.out.println(-1);
                    flag = 0;
                    break;
                }
            }
            if(flag == 0){
                continue;
            }
            int res = (lengthA - lengthB ) % 3 == 0 ? (lengthA - lengthB ) / 3 : (lengthA - lengthB) / 3 + 1;
            System.out.println(res);
        }
    }
}
