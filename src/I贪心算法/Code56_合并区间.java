package I贪心算法;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/1/8 18:41
 */
public class Code56_合并区间 {
    public static void main(String[] args) {
        System.out.println(merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        }));
    }

    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0] == o2[0]){
//                    return o1[1]- o2[1];
//                }
//                return o1[0] - o2[0];
//            }
//        });
        Arrays.sort(intervals , (o1 , o2) -> {
            if(o1[0] == o2[0]){
                   return o1[1]- o2[1];
            }
            return o1[0] - o2[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= right){
                right = Math.max(right,intervals[i][1]);
                left = Math.min(left,intervals[i][0]);
            }else {
                list.add(new int[]{left,right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left,right});
        return list.toArray(new int[list.size()][2]);
    }

}
