package AA秋招.科大讯飞;

/**
 * @author 松鼠
 * @data 2022/7/23 21:11
 */
public class test {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {0, 3}, {1, 2}, {3, 4}, {5, 6}, {7, 8}, {1, 4}, {2, 4}, {3, 5}, {5, 0}, {5, 5}, {2, 0}, {2, 2}, {3, 0}, {3, 3}, {4, 5}, {6, 1}, {3, 7}, {4, 0}, {5, 2}};
//int[][] points = {{0, 6}, {0, 3}, {5, 6}};
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int[] point1 = points[i];
                    int[] point2 = points[j];
                    int[] point3 = points[k];
                    int a = (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
                    int b = (point1[0] - point3[0]) * (point1[0] - point3[0]) + (point1[1] - point3[1]) * (point1[1] - point3[1]);
                    int c = (point2[0] - point3[0]) * (point2[0] - point3[0]) + (point2[1] - point3[1]) * (point2[1] - point3[1]);

                    if (a + b == c || a + c == b || b + c == a) {
                        ++res;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
