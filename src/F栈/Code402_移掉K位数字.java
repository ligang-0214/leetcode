package F栈;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2021/12/27 17:17
 */
public class Code402_移掉K位数字 {
    public void main(String[] args) {

    }

    public String removeKdigits(String num, int k) {
        if(num.length() == k)
            return "0";

        StringBuffer res = new StringBuffer();

        //处理波峰
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while (linkedList.size() > 0 && linkedList.getLast() > num.charAt(i) && k > 0){
                linkedList.removeLast();
                k--;
            }
            linkedList.addLast(num.charAt(i));
        }
        //如果到最后k还是大于0  还有未处理完的
        while (k > 0){
            linkedList.removeLast();
            k--;
        }

        //处理前面的0
        Boolean flag = true;
        for (Character character : linkedList) {
            if(flag && character == '0'){
                continue;
            }
            flag = false;
            res.append(character);
        }

        return res.length()==0 ? "0" : res.toString();
    }
}
