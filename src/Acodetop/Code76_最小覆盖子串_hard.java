package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/26 15:42
 */
public class Code76_最小覆盖子串_hard {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] map = new int[128];
        //记录t中出现的字符的个数
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int count = t.length();
        int start = 0; //最后截取字符串时的起始位置
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (map[cur] > 0) {
                count--;
            }
            map[cur]--;
            if (count == 0) {
                //去掉左边多余的
                while (map[s.charAt(left)] < 0) {
                    map[s.charAt(left)]++;
                    left++;
                }
                if (res > right - left + 1) {
                    res = right - left + 1;
                    start = left;
                }
                map[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
    }

}
