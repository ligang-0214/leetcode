package 基础班.第七节课;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:松鼠
 * Date:2021/7/19 19:26
 *
 * 以最早结束时间排序  然后来安排会议室
 */
public class Code04_BestArrange {
    public static void main(String[] args) {

    }


    /**
     * 项目的信息  开始时间和结束时间
     */
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

//    public static class ProgramComparator implements Comparator<Program> {
//        @Override
//        public int compare(Program o1, Program o2) {
//            return o1.end - o2.end;
//        }
//
//    }

    /**
     *
     * @param programs 项目
     * @param start  设置的开始时间
     * @return 返回可以安排的最多的会议数量
     */
    public static int bestArrange(Program[] programs, int start) {
        //以项目的结束时间早晚  降序排列
        Arrays.sort(programs,  ((o1, o2) -> {return o1.end - o2.end;})    );
        int result = 0;
        //依次遍历所有的项目
        for (int i = 0; i < programs.length; i++) {
            if (start <= programs[i].start) {
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }

}
