package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/2/23 10:57
 */
public class Code415_字符串相加_easy {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }


    public static String addStrings(String num1, String num2) {
        int length1 = num1.length() - 1;
        int length2 = num2.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int flag = 0;
        while (length1 != -1 || length2 != -1){
            int x = length1 >= 0 ? num1.charAt(length1--) - '0' : 0;
            int y = length2 >= 0 ? num2.charAt(length2--) - '0' : 0;
            int temp =  x + y + flag;
            flag = temp / 10;
            stringBuffer.append(temp % 10);
        }
        if(flag == 1){
            stringBuffer.append(1);
        }
        stringBuffer.reverse();
        return stringBuffer.toString();
    }

}
