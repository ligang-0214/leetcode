package AA秋招.网易;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/8/20 16:49
 */
public class demo3 {
    public static void main(String[] args) {
        String speech = "I am so amazed by the sheer excellence of this boy. I am so so so grateful for this";
        String word = "so";
        String[] split = speech.split(" ");
        int res = 0;
        for (int i = 0; i < speech.length() - word.length(); i++) {
            int index = i;
            for (int j = 0; j < word.length(); j++,index++) {
                if((speech.charAt(index)+ "").equalsIgnoreCase(word.charAt(j) + "") == false){
                    break;
                }
            }
            if(index - i == word.length()){
                res++;
            }
        }


        System.out.println(res);


    }


}
