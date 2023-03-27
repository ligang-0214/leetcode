package 测试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author:松鼠
 * Date:2021/6/29 13:33
 */
public class Test6 {
    public static void main(String[] args) {
//        int a = 300;
//        Integer b = 300;
//        Integer c = 300;
//        System.out.println(a == b);//true
//        System.out.println(c == b);//false
//        System.out.println(c.equals(b));//true


//        Scanner sc = new Scanner(System.in);
//        System.out.println(sc.nextInt());
////        sc.next();
//        System.out.println(sc.next());


        byte[] data = new byte[]{0x02, 0x30, 0x31, 0x31, 0x52, 0x30, 0x31, 0x30, 0x30, 0x30, 0x03, 0, 0, 0x0d};
        System.out.println(Arrays.toString(data));
        String checkSum = "";
        checkSum = getCommandCheckNum(data, 11); //计算校验和
        System.out.println(checkSum);
        data[11] = (byte) checkSum.charAt(0);
        data[12] = (byte) checkSum.charAt(1); //存储校验和
        System.out.println(Arrays.toString(data));
        for (byte datum : data) {
            System.out.print(String.format("%3X" , datum));
        }
        System.out.println();
        String newstr = new String(data).trim();
        System.out.println(newstr);








    }

    private static String getCommandCheckNum(byte[] buffer, int m) {
        int i, sum = 0;
        String s = "";
        char c1, c2;
        String ss = "";
        for (i = 0; i < m; i++) {
            sum = sum + buffer[i];
        }
        s = Integer.toHexString(sum);

        c1 = s.charAt(s.length() - 2);
        c2 = s.charAt(s.length() - 1);

        ss = ss + c1 + c2;
        ss = ss.toUpperCase();
        return ss;
    }
}
