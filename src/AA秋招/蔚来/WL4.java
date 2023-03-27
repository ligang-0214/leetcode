package AA秋招.蔚来;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 松鼠
 * @data 2022/7/27 19:38
 */
public class WL4 {
    static int res = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        String[] ss = bf.readLine().split(" ");
        int[] flowers = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            flowers[i] = Integer.parseInt(ss[i]);
        }
        int res = 0;
        for (int i = 0; i < ss.length; i++) {
            if(flowers[i] % 2 == 1){
                res += flowers[i];
            }else {
                res += flowers[i] - 1;
            }
        }
        System.out.println(res);
    }

    private static void dfs(int index, int n, int[] flowers) {
        if (index == flowers.length) {
            if (max % 2 == 1) res = Math.max(res, max);
            return;
        }
        for (int i = 1; i <= flowers[index]; i += 2) {
            max += i;
            dfs(index + 1, n, flowers);
            max -= i;
        }
    }

}
