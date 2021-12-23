package D字符串;

/**
 * @author 松鼠
 * @data 2021/12/22 20:40
 */
@SuppressWarnings("all")
public class Code28_实现strStr_KMP算法 {
    public static void main(String[] args) {

    }


    /**
     * 直接使用kmp算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle){
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }

        int[] next = new int[m];

        next[0] = -1;
        if(m > 1){
            next[1] = 0;

            int flag = 0;
            int i = 2;
            while (i < m){
                if(needle.charAt(i-1) == needle.charAt(flag)){
                    next[i++] = ++flag;
                }else if(flag != 0){
                    flag = next[flag];
                }else {
                    next[i++] = 0;
                }
            }
        }
        int i1 = 0;
        int i2 = 0;
        while (i1 < n  && i2 < m){
            if(haystack.charAt(i1) == needle.charAt(i2)){
                i1++;
                i2++;
            }else if (i2 == 0) { // 模式串跳到开头了 无法往前跳了 那只好匹配串往后跳了
                i1++;
            } else { //如果发现此时既不相等  模式串也没有跳到开头 那就往前跳
                i2 = next[i2];
            }
        }
        return i2 == m ? i1 - i2 : -1;
    }


}
