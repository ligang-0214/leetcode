package APractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/7/10 10:19
 */
public class Code93_复原IP地址_medium {

    List<String> res = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return res;
        }
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int index) {
        if (temp.size() == 4 && index == s.length()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String s1 : temp) {
                stringBuffer.append(s1 + ".");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            res.add(stringBuffer.toString());
            return;
        }

        //剪枝操作
        if ((4 - temp.size()) * 3 < s.length() - index) {
            return;
        }

        for (int i = index; i <= index + 2 && i < s.length(); i++) {
            if (checkStr(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                backtracking(s, i + 1);
                temp.removeLast();
            }
        }
    }

    private boolean checkStr(String s, int left, int right) {
        String substring = s.substring(left, right + 1);
        if (right != left && substring.charAt(0) == '0') {
            return false;
        }
        try {
            if (Integer.valueOf(substring) > 255) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
