package AA秋招.顺丰;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/9/7 17:36
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int res = 0;
        while (list.size() >= m) {
            Integer temp = list.get(2);
            res += temp;
            for (int i = 0; i < m; i++) {
                Integer first = list.removeFirst();
                if (first - temp > 0) {

                    list.addLast(first - temp);
                }
            }
        }
        System.out.println(res);
    }
}
