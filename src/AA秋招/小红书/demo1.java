package AA秋招.小红书;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/28 17:14
 */
public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int id = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += sc.nextInt();
            }
            list.add(new int[]{sum , i + 1});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < n; i++) {
            if(list.get(i)[1] == id){
                System.out.println(i + 1);
                return;
            }
        }


    }
}
