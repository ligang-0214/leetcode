package 测试;

import java.util.Arrays;

/**
 * @author 松鼠
 * @data 2022/2/25 8:49
 */
public class CheckIPAddress {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        String ip = "120.022.0.11";
        String[] split = ip.split("\\.");
//        System.out.println(Arrays.toString(split));
        if(split.length != 4){
            return;
        }

        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            System.out.println(num);
            if(num < 0 || num > 255){
                System.out.println("出现超出范围的！！");
                return;
            }
            if(num != 0 && split[i].charAt(0) == '0'){
                System.out.println("出现以0开头的！！");
                return;
            }
        }



    }
}
