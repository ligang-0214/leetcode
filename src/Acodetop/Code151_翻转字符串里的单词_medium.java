package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/2/25 15:34
 */
public class Code151_翻转字符串里的单词_medium {

    public String reverseWords(String s) {
        if (s.length() < 2) {
            return s;
        }

        StringBuffer res = new StringBuffer();
        LinkedList<String> linkedList = new LinkedList<>();
        char[] charArray = s.toCharArray();
        int index = 0;
        while (charArray[index] == ' ' && index < charArray.length) {
            index++;
        }

        while (index < charArray.length) {
            StringBuffer temp = new StringBuffer();
            while (index < charArray.length && charArray[index] != ' ') {
                temp.append(charArray[index]);
                index++;
            }
            while (index < charArray.length && charArray[index] == ' ') {
                index++;
            }
            linkedList.addFirst(temp.toString());
        }
        for (int i = 0; i < linkedList.size(); i++) {
            if(i == linkedList.size() - 1){
                res.append(linkedList.get(i));
            }else {
                res.append(linkedList.get(i) + " ");
            }
        }
        return res.toString();
    }

}
