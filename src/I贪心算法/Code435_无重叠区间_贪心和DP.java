package I贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 松鼠
 * @data 2022/1/7 19:44
 */
public class Code435_无重叠区间_贪心和DP {

    // 这种题的思路就很难想到  没做过类似的就很难受 所以 多做题才是王道。。。
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int temp = intervals[0][1];
        int flag = 1;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < temp){
                continue;
            }else {
                flag++;
                temp = intervals[i][1];
            }
        }
        return intervals.length - flag;
    }

}
