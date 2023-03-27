package I贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 松鼠
 * @data 2022/1/8 18:40
 */
public class Code452_用最少数量的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int left = points[0][0];
        int right = points[0][1];
        int flag = 1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] >= left && points[i][0] <= right){
                left = Math.max(left , points[i][0]);
                right = Math.min(right , points[i][1]);
            }else {
                flag++;
                left = points[i][0];
                right = points[i][1];
            }
        }
        return flag;

    }

}
