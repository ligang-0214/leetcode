package AInterview.baidu;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/22 20:40
 */
public class BD3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        if (str.charAt(0) == str.charAt(len - 1)) {//处理特殊情况
            System.out.println(1 + " " + (len - 1) + " " + 2 + " " + len +" ");
            return;
        }
        //找下最左边的1和最右边的1相差多远，然后最左边的0和最右边的0相差多远，取max,
        // 中间的是共有的，左右两边相同字符各一个

        //第二题双指针从收尾找相同的字符，先找相同的1，记录下左右指针。再找相同的0，记录下左右指针。
        // 选择左右指针取件跨度更大的。s1=left+1, t1=right, s2=left+2,t2=right+1
        int p1 = -1;
        int p2 = -1;
        int pLen = 0;
        int pI = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '0') {
                p1 = p1 == -1 ? i : p1;
                if (i - p1 > pLen) {
                    pLen = i - p1;
                    pI = i;
                }
            } else {
                p2 = p2 == -1 ? i : p2;
                if (i - p2 > pLen) {
                    pLen = i - p2;
                    pI = i;
                }
            }
        }
        System.out.print((pI - pLen + 1) + " " + pI + " ");
        System.out.println((pI - pLen + 2) + " " + (pI + 1) + " ");
    }
}
