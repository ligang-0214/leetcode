package AInterview.jd;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/3/19 18:53
 */
public class JD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[][] points = new Integer[m][3];
        for (int i = 0; i < m; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            points[i][2] = sc.nextInt();
        }
        LinkedList<Integer> recordPoint = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        //按照边排序
        Arrays.sort(points, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[2] - o1[2];
            }
        });
        for (int i = 0; i < m; i++) {
            if (recordPoint.size() == n) {
                System.out.println(res);
                return;
            }
            if (!recordPoint.contains(points[i][0]) && !recordPoint.contains(points[i][1])) {
                recordPoint.addLast(points[i][0]);
                recordPoint.addLast(points[i][1]);
                res = Math.min(res, points[i][2]);
            } else if (!recordPoint.contains(points[i][1])) {
                recordPoint.addLast(points[i][1]);
                res = Math.min(res, points[i][2]);
            }else if(!recordPoint.contains(points[i][0])){
                recordPoint.addLast(points[i][0]);
                res = Math.min(res, points[i][2]);
            }
        }
        System.out.println(res);
    }
}
