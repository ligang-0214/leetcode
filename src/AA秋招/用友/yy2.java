package AA秋招.用友;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author 松鼠
 * @data 2022/8/3 18:33
 */
public class yy2 {
    public int[][] count(String str) {
        ArrayList<int[]> res = new ArrayList<>();
        int[] map = new int[10];
        char[] s = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (s[i] == 'a') {
                map[2] += 1;
            } else if (s[i] == 'b') {
                map[2] += 2;
            } else if (s[i] == 'c') {
                map[2] += 3;
            } else if (s[i] == 'd') {
                map[3] += 1;
            } else if (s[i] == 'e') {
                map[3] += 2;
            } else if (s[i] == 'f') {
                map[3] += 3;
            } else if (s[i] == 'g') {
                map[4] += 1;
            } else if (s[i] == 'h') {
                map[4] += 2;
            } else if (s[i] == 'i') {
                map[4] += 3;
            } else if (s[i] == 'j') {
                map[5] += 1;
            } else if (s[i] == 'k') {
                map[5] += 2;
            } else if (s[i] == 'l') {
                map[5] += 3;
            } else if (s[i] == 'm') {
                map[6] += 1;
            } else if (s[i] == 'n') {
                map[6] += 2;
            } else if (s[i] == 'o') {
                map[6] += 3;
            } else if (s[i] == 'p') {
                map[7] += 1;
            } else if (s[i] == 'q') {
                map[7] += 2;
            } else if (s[i] == 'r') {
                map[7] += 3;
            } else if (s[i] == 's') {
                map[7] += 4;
            } else if (s[i] == 't') {
                map[8] += 1;
            } else if (s[i] == 'u') {
                map[8] += 2;
            } else if (s[i] == 'v') {
                map[8] += 3;
            } else if (s[i] == 'w') {
                map[9] += 1;
            } else if (s[i] == 'x') {
                map[9] += 2;
            } else if (s[i] == 'y') {
                map[9] += 3;
            } else if (s[i] == 'z') {
                map[9] += 4;
            } else if (s[i] == '@') {
                map[1] += 1;
            } else if (s[i] == '!') {
                map[1] += 2;
            } else if (s[i] == '.') {
                map[1] += 3;
            } else if (s[i] == '/') {
                map[1] += 4;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (map[i] != 0) {
                res.add(new int[]{i, map[i]});
            }
        }
        return res.toArray(new int[0][0]);
    }

}
