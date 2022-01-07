package I贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 松鼠
 * @data 2022/1/7 14:44
 */
public class Code253_会议室二 {
    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{
                {0, 30},
                {5, 10},
                {15, 20},
                {8,16},
                {8,14}
        }));
    }

    public static int minMeetingRooms(int[][] intervals){
        //按照先开始在前  如果开始时间相同 先结束的在前
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
//        for (int[] interval : intervals) {
//            System.out.println(interval[0] + "  " + interval[1]);
//        }

        Queue<Integer> queue = new PriorityQueue<>(); //小根堆
        queue.add(intervals[0][1]); //先把第一个结束时间扔进去
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= queue.peek()){ //如果当前的起始时间大于小根堆中最早结束的时间  那堆顶的元素可以弹出
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return queue.size(); //最后整个堆的大小就是所需的答案
    }

}
