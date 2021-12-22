package C哈希表;


import java.util.HashMap;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 注意：字串 和 子序列 不一样
 * @author 松鼠
 * @data 2021/12/20 10:36
 */
public class Code3_无重复字符的最长子串SS {
    public static void main(String[] args) {
        String s = "abcdcabefg";
        System.out.println(lengthOfLongestSubstring1(s));
    }





    public static int lengthOfLongestSubstring1(String s) {
        if (s.length()<= 1) return s.length();
        //存储某个字符按最近一次出现的坐标
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        //我之前在想如何处理a、b、c、d、c、a、b   第二次到a时，第一次扔进map中的a怎么办
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                //这里的处理了，在if判断中，如果之前扔进map中的字符的位置在left左边那就没影响，left不变
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);  //这里相当于重新给a赋予新的位置
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
