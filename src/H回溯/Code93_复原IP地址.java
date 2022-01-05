package H回溯;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2021/12/30 10:12
 */
public class Code93_复原IP地址 {

    List<String> result = new LinkedList<>();
    LinkedList<String> temp = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12)
            return result;
        backtracking(s,0);
        return result;
    }

    /**
     * 反正还是回溯那套模板  按着走下来就行了
     * @param s
     * @param startIndex
     */
    private void backtracking(String s, int startIndex) {
        if(temp.size() == 8){
            if(startIndex == s.length()){
                temp.removeLast();
                StringBuffer stringBuffer = new StringBuffer();
                for (String s1 : temp) {
                    stringBuffer.append(s1);
                }
                result.add(stringBuffer.toString());
                temp.add(".");
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if(isValid(s,startIndex,i)){
                temp.add(s.substring(startIndex,i+1));
                temp.add(".");
            }else {
                continue;
            }
            backtracking(s,i + 1);
            temp.removeLast();
            temp.removeLast();
        }

    }

    /**
     * 判断数字是否合法  因为题目给定了一些范围  所以判断不需要这么严格
     * @param s
     * @param startIndex
     * @param toIndex
     * @return
     */
    private boolean isValid(String s, int startIndex, int toIndex) {
//        if (startIndex > toIndex) {
//            return false;
//        }
        if (s.charAt(startIndex) == '0' && startIndex != toIndex) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = startIndex; i <= toIndex; i++) {
//            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
//                return false;
//            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
