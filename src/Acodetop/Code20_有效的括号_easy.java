package Acodetop;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/2/22 14:22
 */
public class Code20_有效的括号_easy {

    public boolean isValid(String s) {
        if(s.length() % 2 ==1)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() && map.containsKey(s.charAt(i))){
                return false;
            }
            if (!map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                if(map.get(s.charAt(i)) == stack.peek()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
