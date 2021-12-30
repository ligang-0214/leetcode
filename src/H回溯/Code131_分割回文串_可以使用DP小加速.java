package H回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2021/12/30 9:11
 */
public class Code131_分割回文串_可以使用DP小加速 {

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        backtracking(s,0);
        return result;
    }

    private void backtracking(String s, int startIndex) {
        //如果截取到最后一位了  就说明到底了 就可以存结果了
        if(startIndex == s.length()){
            result.add(new LinkedList<>(path));
            return;
        }
        //这里的 i 就表示 每次从 startIndex 到 i 判断是否为回文串 并且截取这一段字符
        for (int i = startIndex; i < s.length(); i++) {
            if(isPalindrome(s, startIndex, i)){ //如果是回文串的话
                String substring = s.substring(startIndex, i+1); //包前不包后
                path.add(substring);
            }else {
                continue;
            }
            backtracking(s,i+1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int startIndex, int end) {
        while (startIndex < end){
            if(s.charAt(startIndex) != s.charAt(end))
                return false;
            startIndex++;
            end--;
        }
        return true;
    }
}
