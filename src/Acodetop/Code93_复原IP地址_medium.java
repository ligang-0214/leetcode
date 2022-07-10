package Acodetop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 松鼠
 * @data 2022/2/27 14:36
 */
public class Code93_复原IP地址_medium {

    ArrayList<String> res = new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4 || s.length() > 12){
            return res;
        }
        dfs(s,0);
        return res;

    }

    private void dfs(String s, int startIndex) {
        if(temp.size() == 8){
            if(startIndex == s.length()){
                temp.removeLast();
                StringBuffer buffer = new StringBuffer();
                for (String s1 : temp) {
                    buffer.append(s1);
                }
                res.add(buffer.toString());
                temp.addLast(".");
            }
            return;
        }

        //这里自己加了一个剪枝操作  就是如果后面剩余的长度已经超过所需要的长度  那直接剪掉
        //比如：  1.1.1.11111   后面生了5个  但是后面最多只需要3个  那肯定不符合  就剪掉
        if((s.length() - startIndex) > (4 - temp.size()/2)*3){
            return;
        }

        for (int i = startIndex; i <= startIndex + 2 && i < s.length(); i++) {
            if(checkRight(s, startIndex , i)){
                temp.addLast(s.substring(startIndex , i+1));
                temp.addLast(".");
            }else {
                return;
            }
            dfs(s , i+1);
            temp.removeLast();
            temp.removeLast();
        }

    }

    private boolean checkRight(String s, int startIndex, int endIndex) {
        if(s.charAt(startIndex) == '0' && startIndex != endIndex){
            return false;
        }
        int temp = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                return false;
            }
            temp = temp*10 + s.charAt(i) - '0';
            if(temp > 255){
                return false;
            }
        }
        return true;
    }

}
