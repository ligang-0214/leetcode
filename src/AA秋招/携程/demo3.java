package AA秋招.携程;

import java.util.*;

/**
 * @author 松鼠
 * @data 2022/8/30 20:03
 */
public class demo3 {
    static  String s = "";
    static  ArrayList<int[]> ans = new ArrayList<int[]>();
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        s = sc.next();
//        int[][] bian = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            bian[i][0] = a;
//            bian[i][1] = b;
//            ans[a]
//        }
//        int res = 0;
//        for (int[] ints : bian) {
//            if(judge(ints[0] , ints[1] , n) && judge(ints[1] , ints[0] , n)){
//                res++;
//            }
//        }
//        System.out.println(res);


    }

    private static boolean judge(int t, int x , int n) {
        int r = 0;
        int g = 0;
        int b = 0;
        int[] ls = new int[n + 1];
        Arrays.fill(ls , 0);
        ls[t] = 1;
        Set<Integer> ms = new HashSet<>();
        dfs(ls , x , ms);
        Iterator<Integer> iterator = ms.iterator();
        for (Integer m : ms) {
            if(s.charAt(m - 1) == 'r'){
                r++;
            }else if(s.charAt(m - 1) == 'g'){
                g++;
            }else {
                b++;
            }
        }
        if(r > 0 && g > 0 && b > 0){
            return true;
        }else {
            return false;
        }
    }

    private static void dfs(int[] ls, int x, Set<Integer> ms ) {
//        for (int i = 0; i < ans[x]; i++) {
//            if(ls[i] == 0){
//                ms.add(i);
//                ls[i] = 1;
//                dfs(ls, i , ms);
//            }
//        }
    }
}
