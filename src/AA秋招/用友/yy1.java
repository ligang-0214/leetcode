package AA秋招.用友;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 松鼠
 * @data 2022/8/3 18:33
 */
public class yy1 {
    public int[][] count(String str) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == '@') {
                map.put(1, map.getOrDefault(1, 0) + 1);
            }
            if (str.charAt(i) == '!') {
                map.put(1, map.getOrDefault(1, 0) + 2);
            }
            if (str.charAt(i) == '.') {
                map.put(1, map.getOrDefault(1, 0) + 3);
            }
            if (str.charAt(i) == '/') {
                map.put(1, map.getOrDefault(1, 0) + 4);
            }
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'r') {
                int key = (str.charAt(i) - 97) / 3 + 2;
                int val = (str.charAt(i) - 97) % 3 + 1;
                map.put(key, map.getOrDefault(key, 0) + val);
            }
            if (str.charAt(i) == 's') {
                map.put(7, map.getOrDefault(7, 0) + 4);
            }
            if (str.charAt(i) == 't') {
                map.put(8, map.getOrDefault(8, 0) + 1);
            }
            if (str.charAt(i) == 'u') {
                map.put(8, map.getOrDefault(8, 0) + 2);
            }
            if (str.charAt(i) == 'v') {
                map.put(8, map.getOrDefault(8, 0) + 3);
            }
            if (str.charAt(i) == 'w') {
                map.put(9, map.getOrDefault(9, 0) + 1);
            }
            if (str.charAt(i) == 'x') {
                map.put(9, map.getOrDefault(9, 0) + 2);
            }
            if (str.charAt(i) == 'y') {
                map.put(9, map.getOrDefault(9, 0) + 3);
            }
            if (str.charAt(i) == 'z') {
                map.put(9, map.getOrDefault(9, 0) + 4);
            }
        }
        int len = map.size();
        int[][] res = new int[len][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getKey();
            i++;
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        return res;

    }
}
