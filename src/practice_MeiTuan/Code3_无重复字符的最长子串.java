package practice_MeiTuan;

import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/3/29 17:56
 */
public class Code3_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left , map.get(s.charAt(i)));
            }
            map.put(s.charAt(i) , i);
            res = Math.max(res , i - left );
        }
        return res;

    }

}
