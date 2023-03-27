package I贪心算法;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/1/7 14:15
 */
public class Code402_移掉K位数字 {

    // 这题之前写过  用栈来处理  现在想想好像确实是用到贪心的思想
    public String removeKdigits(String num, int k) {
        if(num.length() == k)
            return "0";

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (!list.isEmpty() && num.charAt(i) < list.getLast() && k > 0 ){
                k--;
                list.removeLast();
            }
            list.add(num.charAt(i));
        }

        while (k > 0){
            list.removeLast();
            k--;
        }

        StringBuffer res = new StringBuffer();
        //处理前面的0
        Boolean flag = true;
        for (Character character : list) {
            if(flag && character == '0'){
                continue;
            }
            flag = false;
            res.append(character);
        }

        return res.length()==0 ? "0" : res.toString();

    }

}
