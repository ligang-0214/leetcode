package AInterview.alibaba;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 松鼠
 * @data 2022/3/25 8:29
 */
public class ali1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        while (t-- > 0){
            String str = sc.nextLine();
            if(temp.contains(str)){
                res.add("acount existed");
                continue;
            }
            int len = str.length();
            if(len < 6 || len > 12){
                res.add("illegal length");
                continue;
            }
            int flag = 0;
            for (int i = 0; i < len; i++) {
//                Pattern p = Pattern.compile(".*\\d+.*");
//                Matcher matcher = p.matcher(str);
//                if(matcher.matches()){
//                    res.add("illegal charactor");
//                    flag = 1;
//                    break;
//                }
                if(!Character.isLowerCase(str.charAt(i)) && !Character.isUpperCase(str.charAt(i))  ){
                    res.add("illegal charactor");
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                temp.add(str);
                res.add("registration complete");
            }
        }
        for (String re : res) {
            System.out.println(re);
        }
    }
}
