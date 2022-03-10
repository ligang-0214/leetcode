package Acodetop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author 松鼠
 * @data 2022/2/20 20:20
 */
public class Code3_无重复字符的最长子串_medium {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left , map.get(s.charAt(i)) );
            }
            map.put(s.charAt(i) , i + 1);
            res = Math.max(res , i - left + 1);
        }
        return res;
    }
}
