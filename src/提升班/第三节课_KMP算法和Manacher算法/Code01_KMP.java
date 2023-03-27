package 提升班.第三节课_KMP算法和Manacher算法;

import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/8/2 19:43
 */
@SuppressWarnings("all")
public class Code01_KMP {

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(Arrays.toString(getNextArray(match.toCharArray())));
//        System.out.println(getIndexOf(str, match));

    }


    /**
     * 主要的业务逻辑
     * @param s 匹配串
     * @param m 模式串
     * @return
     */
    public static int getIndexOf(String s, String m) {
        //这个条件要写完
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        System.out.println(Arrays.toString(next));
        //这里是精华   O(N)
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) { //如果此时相等  那就模式串和匹配串都往后跳
                i1++;
                i2++;
            } else if (i2 == 0) { // 模式串跳到开头了 无法往前跳了 那只好匹配串往后跳了
                i1++;
            } else { //如果发现此时既不相等  模式串也没有跳到开头 那就往前跳
                i2 = next[i2];
            }
        }
        //如果i2越界了  就说明匹配完成了  那么i1-i2就是匹配串的起始点
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * 这里生成前缀表是精华   O(M)
     * 前缀表中数据的含义是 它之前字符串的最大  前缀和后缀匹配 的 值
     * 例如：ababa  最大前后缀相等就是3  aba aba
     * @param ms
     * @return
     */
    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1; //定死的
        next[1] = 0; //定死的
        int i = 2;
        int flag = 0; //拿哪个位置的字符和 i-1 的字符进行比较  最开始肯定是0位置
        while (i < next.length) {
            if (ms[i - 1] == ms[flag]) { //看i位置的前一位是否与 flag位置相等  i和flag都变化
                next[i++] = ++flag;
            } else if (flag > 0) { // 说明flag还没有跳到开头  还可以往前跳  flag变化
                flag = next[flag];
            } else { // flag跳到开头了 那i位置只能为0  i变化
                next[i++] = 0;
            }
        }
        return next;
    }

}
