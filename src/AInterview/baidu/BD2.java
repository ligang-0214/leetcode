package AInterview.baidu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/22 18:42
 */
public class BD2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list2.addLast(1);
        list2.addLast(2);
        int max = 0;
        int flag1 = 0;
        int flag0 = 0;
        int flag = 0;
        for (int i = 1; i <= str.length() - 1; i++) {//从长度为1开始暴力匹配
            for (int j = 0; j + i <= str.length(); j++) {
                int[] process1 = process(str, j, i);
                flag = 0;
                for (int k = j + 1; k + i <= str.length(); k++) {
                    int[] process2 = process(str, k, i);
                    if (process1[0] == process2[0] && process1[1] == process2[1]) {
                        list1.removeLast();
                        list1.removeLast();
                        list2.removeLast();
                        list2.removeLast();
                        list1.addLast(j + 1);
                        list2.addLast(k + 1);
                        list1.addLast(j + 1 + i - 1);
                        list2.addLast(k + 1 + i - 1);
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1) {
                    break;
                }
            }
        }
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
        for (Integer integer : list2) {
            System.out.print(integer + " ");
        }

    }

    private static int[] process(String str, int startIndex, int len) {
        int[] res = new int[2];
        int flag1 = 0;
        int flag0 = 0;
        String substring = str.substring(startIndex, startIndex + len);
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '1') {
                flag1++;
            } else {
                flag0++;
            }
        }
        res[0] = flag0;
        res[1] = flag1;
        return res;
    }
}
