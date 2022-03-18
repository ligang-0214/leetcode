package ANowCoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 松鼠
 * @data 2022/3/18 19:43
 */
public class BM58_字符串的排列_medium {

    ArrayList<String> res = new ArrayList<>();
    StringBuffer stringBuffer = new StringBuffer();
    boolean[] used;
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        used = new boolean[chars.length];
        Arrays.fill(used , false);
        backtracking(chars);
        return res;
    }

    private void backtracking(char[] chars) {
        if(stringBuffer.length() == chars.length){
            res.add(stringBuffer.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if(used[i]){
                continue;
            }
            if(i > 0 && chars[i] == chars[i - 1] && used[i - 1] == false){
                continue;
            }
            used[i] = true;
            stringBuffer.append(chars[i]);
            backtracking(chars);
            used[i] = false;
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }

    }

}
