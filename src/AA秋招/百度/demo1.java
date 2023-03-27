package AA秋招.百度;

/**
 * @author 松鼠
 * @data 2022/8/25 11:30
 */
public class demo1 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "9934";
        System.out.println(sum(num1 , num2));
    }

    public static String sum(String num1, String num2){
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int flag = 0;
        while (len1 >= 0 || len2 >= 0){
            int temp1 = len1 == -1 ? 0 : Integer.valueOf(num1.charAt(len1--)) - 48;
            int temp2 = len2 == -1 ? 0 : Integer.valueOf(num2.charAt(len2--)) - 48;
            int sum = temp1 + temp2 + flag;
            flag = sum >= 10 ? 1 : 0;
            stringBuffer.append(sum % 10);
        }
        if(flag == 1){
            stringBuffer.append(1);
        }
        return  stringBuffer.reverse().toString();
    }

}
