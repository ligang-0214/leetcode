package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/28 8:55
 */
public class Code43_字符串相乘_medium {
    public static void main(String[] args) {
        multiply("2","3");
    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String ans = "0";
        int len1 = num1.length();
        int len2 = num2.length();

        for (int i = len1 - 1; i >= 0; i--) {
            int flag = 0;
            StringBuffer stringBuffer = new StringBuffer(0);
            for (int j = 0; j < len1 - 1 - i; j++) {
                stringBuffer.append("0");
            }
            for (int j = len2 - 1 ; j >= 0 ; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + flag;
                flag = temp / 10;
                stringBuffer.append(temp % 10);
            }
            if(flag != 0){
                stringBuffer.append(flag);
            }
            ans = addStrings(ans , stringBuffer.reverse().toString());
        }
        return ans;
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
