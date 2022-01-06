package I贪心算法;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/1/6 10:49
 */
public class Code455_分发饼干 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = s.length - 1;
        for (int i = g.length -1 ; i >= 0; i--) {
            if(index >= 0 && s[index] >= g[i]){
                count++;
                index--;
            }
        }
        return count;
    }

}
