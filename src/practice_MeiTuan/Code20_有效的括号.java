package practice_MeiTuan;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2022/3/29 20:34
 */
public class Code20_有效的括号 {

    public boolean isValid(String s) {
        if(s == null || s.length() %2 == 1){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(' , ')');
        map.put('[' , ']');
        map.put('{' , '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() && map.containsValue(s.charAt(i))){
                return false;
            }
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                Character peek = stack.peek();
                if(map.get(peek) == s.charAt(i)){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

}
