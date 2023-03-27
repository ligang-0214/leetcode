package F栈;

import java.util.LinkedList;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 字典序：换成数字更好理解一点 a:1,b:2,c:3 那么：acdb => 1342 dcab => 4312
 * 4312 > 1342 所以 dcab > acdb 也可以想象在英语词典里，acdb会比dcab出现得更早，所以acdb的字典序更小
 *
 * @author 松鼠
 * @data 2021/12/28 10:59
 */
@SuppressWarnings("all")
public class Code316_去除重复字母 {
    public static void main(String[] args) {
//        String res = removeDuplicateLetters("cbacdcbc");
        String res = removeDuplicateLetters("bbcaac");
        System.out.println(res);
    }

    /**
     * 使用单调栈的方式来处理
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        int[] flag = new int[26]; //记录某个字母是否已经在单调栈中
        int[] count = new int[26]; // 记录某个字母出现的数量
        LinkedList<Character> stack = new LinkedList<>();
        //计算出现的次数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            //如果当前元素还没有进栈  就开始处理单调栈中的内容
            if(flag[s.charAt(i) - 'a'] == 0){
                while (!stack.isEmpty() && stack.getLast() >= s.charAt(i) && count[stack.getLast()- 'a'] > 0){
                    Character character = stack.removeLast();
                    flag[character - 'a'] = 0;
                }
                stack.addLast(s.charAt(i));
                flag[s.charAt(i) - 'a'] = 1;
            }
            count[s.charAt(i) - 'a']--; //如果已经进栈了  就处理该元素的数量
        }
        //处理结果
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : stack) {
            stringBuffer.append(character);
        }
        return stringBuffer.length() == 0 ? "" : stringBuffer.toString();
    }
}
