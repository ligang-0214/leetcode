package APractice;

import com.sun.org.apache.bcel.internal.generic.FSUB;

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
        if (index == s.length() && temp.size() == 8) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < temp.size() - 1; i++) {
                buffer.append(temp.get(i));
            }
            res.add(buffer.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (checkStr(s, index, i + 1)) {
                temp.addLast(s.substring(index, i + 1));
                temp.addLast(".");
                backtracking(s, i + 1);
                temp.removeLast();
                temp.removeLast();
            }else {
                return;
            }
        }
    }

    private boolean checkStr(String s, int startIndex, int endIndex) {
        String substring = s.substring(startIndex, endIndex);
        //处理前导0的情况
        if(substring.length() > 1 && substring.charAt(0) == '0'){
            return false;
        }
        Integer integer = -1;
        try {
            integer = Integer.valueOf(substring);
        } catch (Exception e) {
            return false;
        }
        if (integer <= 0 || integer >= 255) {
            return false;
        }
        return true;
    }


}
