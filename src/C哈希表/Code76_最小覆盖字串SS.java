package C哈希表;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * @author 松鼠
 * @data 2021/12/20 15:38
 */
public class Code76_最小覆盖字串SS {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }


    public static String minWindow(String s, String t) {
        if(s.length() == 0 || s == null || t.length() ==0 || t == null || s.length() < t.length())
            return "";

        int[] tmp = new int[128];
        //将每个出现的字符和出现的次数放进tmp中
        for (int i = 0; i < t.length(); i++) {
            tmp[t.charAt(i)] ++;
        }

        int left = 0,right = 0;
        int count = t.length(); // 总共需要多少个字符
        int res = Integer.MAX_VALUE;
        int start = 0;
        //遍历s字符串
        while (right < s.length()){
            char cur = s.charAt(right);
            if(tmp[cur] >0)
                count--;
            tmp[cur]--;
            if(count == 0){
                //把左边没用的字符去掉
                while (tmp[s.charAt(left)] < 0){
                    tmp[s.charAt(left)]++;
                    left++;
                }
                //比较res
                if(res > right - left + 1){
                    res = right - left + 1;
                    start = left;
                }
                //把最左边这个有效字符去掉，并把数量加一
                tmp[s.charAt(left)]++;
                left ++;
                count++;
            }
            right ++;
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start,start + res);

    }



}
