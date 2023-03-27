package 测试.输入输出;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/7/23 10:08
 */
public class InputTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /**
         * 输入：  123   456
         * 输出：123
         * 以读到有效字符串为结束准则，空白会不读取
         * 如果输入的内容之间存在空格，空格会自动过滤掉不读取. 如果读取内容为有效字符串+空格+有效字符串情况，
         * 只会读取到空格之前的内容，空格之后内容会过滤掉
         */
//        String next = sc.next();
//        System.out.println(next);


        /**
         * 输入：  123  456
         * 输出：  123  456
         * 以Enter为结束准则，会读取敲击Enter之前所有输入的内容包括空格。
         */
//        String s = sc.nextLine();
//        System.out.println(s);




    }
}
