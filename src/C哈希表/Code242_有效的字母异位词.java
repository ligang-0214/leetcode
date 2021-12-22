package C哈希表;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * @author 松鼠
 * @data 2021/12/20 10:12
 */
public class Code242_有效的字母异位词 {
    public static void main(String[] args) {
        String s = "bat";
        String t = "bat";
        System.out.println(isAnagram1(s,t));
    }


    public static boolean isAnagram1(String s, String t) {
        if(s.equals(t) == true)
            return true;
        if(s.length() != t.length())
            return false;

        int[] sArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            sArr[t.charAt(i) - 'a'] -= 1;
        }

        for (int i = 0; i < sArr.length; i++) {
            if(sArr[i] != 0)
                return false;
        }

        return true;
    }


}
