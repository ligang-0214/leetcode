package I贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/1/7 16:31
 */
public class Code406_根据身高重建队列 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1]; // 如果第一列相同  按照第二列从小到大排列
                }
                return o2[0] - o1[0]; //按照第一列从大到小排列
            }
        });

        LinkedList<int[]> list = new LinkedList<>();

        for (int[] p : people) {
            //此时的 p[i][1] 就是前面有几个身高比它自己高/相等的 也就是它自己要放置的位置
            //所以从前往后 一边遍历一边插
            list.add(p[1],p);
        }
        return list.toArray(new int[people.length][2]);
    }

}
