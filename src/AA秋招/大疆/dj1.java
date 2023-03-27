package AA秋招.大疆;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 松鼠
 * @data 2022/8/7 18:34
 */
public class dj1 {

    public void process(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[0][0] > arr[0][1]) {
                int temp = arr[0][0];
                arr[0][0] = arr[0][1];
                arr[0][1] = temp;
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });






    }
}
