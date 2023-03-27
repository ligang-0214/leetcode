package 基础班.第八节课;

import java.util.ArrayList;

/**
 * 打印一个字符串的全排列情况
 * Author:松鼠
 * Date:2021/7/20 20:52
 */
public class Code03_PrintAllPermutations {
    public static void main(String[] args) {
        ArrayList<String> list = Permutation("abcc");
        System.out.println(list);
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs, 0, res);
        return res;
    }

    public static void process(char[] chs, int i, ArrayList<String> res) {
        if (i == chs.length) {
            res.add(new String(chs));
        }
        boolean[] visit = new boolean[26];//去重复的时候才有用
        for (int j = i; j < chs.length; j++) {
            if (!visit[chs[j] - 'a']) {
                visit[chs[j] - 'a'] = true;
                swap(chs, i, j);
                process(chs, i + 1, res);
                swap(chs, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

}
