package AA秋招.容知日新;

import java.util.HashSet;

/**
 * @author 松鼠
 * @data 2022/9/3 18:35
 */
public class demo1 {
    public static void main(String[] args) {

    }
    public String longestDupSubstring (String s) {
        // write code here
        HashSet<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = -1 , ans = 0;
        int leftFlag = -1;
        for (int i = 0; i < n; i++) {
            if(i != 0){
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))){
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            if(rk - i + 1 > ans){
                leftFlag = i;
                ans = rk - i + 1;
            }
        }
        System.out.println("hhh");
        if(leftFlag == -1){
            return "";
        }else {
            return s.substring(leftFlag , ans + leftFlag );
        }


    }
}
