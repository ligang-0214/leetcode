package AA秋招.网易;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/8/20 14:47
 */
public class demo1 {
    static String path = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        String s1 = a + "";
        String s2 = b + "";

        dfs(s1 , set1 , 0);
        dfs(s2 , set2 , 0);
        int res = Integer.MAX_VALUE;

        for (Integer integer : set1) {
            for (Integer integer1 : set2) {
                if(integer > integer1){
                    int x = integer;
                    int y = integer1;
                    if(x % y == 0){
                        int i = s1.length() - (x + "").length() + s2.length() - (y + "").length();
                        if(i < res){
                            res = i;
                        }
                    }
                }else {
                    int x = integer1;
                    int y = integer;
                    if(x % y == 0){
                        int i = s1.length() - (x + "").length() + s2.length() - (y + "").length();
                        if(i < res){
                            res = i;
                        }
                    }

                }
            }
        }
        if(res == Integer.MAX_VALUE){
            res = -1;
        }
        System.out.println(res);
    }

    private static void dfs(String s1, HashSet<Integer> set1, int index) {

        for (int i = index ; i < s1.length() ; i++) {
            path += s1.charAt(i);
            set1.add(Integer.valueOf(path));
            dfs(s1 , set1 , i + 1);
            path = path.substring(0 , path.length() - 1);
        }
    }
}
