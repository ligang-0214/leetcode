package 基础班.第八节课;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:松鼠
 * Date:2021/7/20 19:57
 */
public class Code02_PrintAllSubsquences {
    public static void main(String[] args) {

    }

    static List<List<Character>> result = new ArrayList<>();
    public static List<List<Character>> printAllSubsquence(String str) {
        char[] chars = str.toCharArray();
        process( chars , 0 , new ArrayList<>() );
        return result;
    }

    private static void process(char[] chs, int i, List<Character> res) {
        if(i == chs.length) {
            result.add(res);
        }
        List<Character> resKeep = new ArrayList<>();
        resKeep.addAll(res);
        resKeep.add(chs[i]);
        process(chs, i+1, resKeep);
        List<Character> resNoInclude = new ArrayList<>();
        process(chs, i+1, resNoInclude);
    }


}
