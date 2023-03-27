package D字符串;

import java.util.ArrayList;

/**
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 注意:  输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括;
 *       如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
 *
 *
 * 进阶：尝试使用 O(1) 额外空间复杂度的原地解法 ！！！！！！！【没找到java版本的，只有c++有相关实现】
 *
 * @author 松鼠
 * @data 2021/12/22 19:03
 */
@SuppressWarnings("all")
public class Code151_反转字符串里的单词 {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }


    /**
     * 基本的暴力解法  时间和空间都很高
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        ArrayList<String> strings = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (right < s.length()){
            //使快慢指针都指向某个单词的开头
            while (right < s.length() &&  s.charAt(right) == ' ' ){
                right++;
                left++;
            }
            //使快指针指向某个单词的结尾的下一位
            while (right < s.length() && s.charAt(right) != ' '){
                right++;
            }
            if(right == left)  //为了防止最后一次把‘ ’ 也截取进来  比如 s = "  hello world  "
                break;
            strings.add(s.substring(left,right)); //substring包前不包后
            left = right;
        }
        //倒序处理结果
        String res = new String();
        for (int i = strings.size()-1; i >= 0; i--) {
            if(i == 0){
                res += strings.get(i);
            }else {
                res += strings.get(i) + " ";
            }
        }
        return res;
    }


    /**
     * 另外的解法：
     * 1.移除多余空格
     * 2.将整个字符串反转
     * 3.将每个单词反转
     *
     *
     * 举个例子，源字符串为："the sky is blue "
     * 移除多余空格 : "the sky is blue"
     * 字符串反转："eulb si yks eht"
     * 单词反转："blue is sky the"
     *
     * @param s
     * @return
     */
    public static String reverseWordsAdvanced(String s){
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();

    }

    /**
     * 去除字符串中的空格
     * @param s
     * @return
     */
    private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        //去除首位部分的空格
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            //这个判断是精华
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串
     * @param sb
     * @param start
     * @param end
     */
    public static void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    /**
     * 利用双指针处理单词的反转
     * @param sb
     */
    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

}
