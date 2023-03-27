package AA秋招.美团;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/8/20 10:11
 */
public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] index = new int[3][2];
        for (int i = 0; i < 3; i++) {
            index[i][0] = sc.nextInt();
            index[i][1] = sc.nextInt();
        }
        String next = sc.next();
        String[] s = next.split(" ");
        LinkedList<String> process = process(0, s, index, N);
//        Arrays.sort(process, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String[] s1 = o1.split(" ");
//                String[] s2 = o2.split(" ");
//                if(s1[0].equals(s2[0])){
//                    return Integer.valueOf(s1[1]) - Integer.valueOf(s2[1]);
//                }else {
//                    return Integer.valueOf(s1[0]) - Integer.valueOf(s2[0]);
//                }
//
//            }
//        });


    }

    private static LinkedList<String>  process(int i, String[] s, int[][] index , int N) {
        Integer temp = Integer.valueOf(s[i]);
        LinkedList<String> res = new LinkedList<>();
        for (int x = 0; x <= temp; x++) {
            int y = temp - x;
            if(index[i][0] - x >= 1 ){
                if(index[i][1] - y >= 1){
                    res.add((index[i][0] - x + " ") + (index[i][1] - y + ""));
                }
                if(index[i][1] + y <= N){
                    res.add((index[i][0] - x + " ") + (index[i][1] + y + ""));
                }
            }
            if(index[i][0] + x <= N ){
                if(index[i][1] - y >= 1){
                    res.add((index[i][0] + x + " ") + (index[i][1] - y + ""));
                }
                if(index[i][1] + y <= N){
                    res.add((index[i][0] + x + " ") + (index[i][1] + y + ""));
                }
            }
        }
        return res;
    }
}
