package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/10 16:33
 */
public class Code14_最长公共前缀_easy {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        int index = 0;
        while (true){
            char temp;
            if(index < strs[0].length()){ //这里是防止取的strs[0]超过了最大长度
                temp = strs[0].charAt(index);
            }else {
                return strs[0].substring(0,index);
            }
            for (String str : strs) {
                if(str.length() -1 < index){
                    return strs[0].substring(0,index);
                }else {
                    if(str.charAt(index) != temp){
                        return strs[0].substring(0,index);
                    }
                }
            }
            index++;
        }
    }

}
