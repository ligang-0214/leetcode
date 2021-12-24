package F栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2021/12/23 15:06
 */
public class Code20_有效的括号 {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        if(s.length() % 2 ==1)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.add(s.charAt(i));
            }else {
                if(stack.isEmpty() || map.get(s.charAt(i)) != stack.peek()){
                    return false;
                }else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
