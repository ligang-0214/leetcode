package F栈;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2021/12/28 10:15
 */
public class Code1047_删除字符串中所有相邻重复项 {
    public void main(String[] args) {

    }

    /**
     * 注意： abbbacd  处理完就是  abacd   bbb不需要都处理  只有成对的才会处理
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() == false && stack.getLast() == s.charAt(i)){
                stack.removeLast();
                continue;
            }
            stack.addLast(s.charAt(i));
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Character character : stack) {
            stringBuffer.append(character);
        }
        return stringBuffer.length() == 0 ? "" : stringBuffer.toString();
    }
}
