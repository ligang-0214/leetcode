package AA秋招.小红书;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 松鼠
 * @data 2022/8/28 17:33
 */
public class demo3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n个人
        int[] conn = new int[n];
        for (int i = 1; i < n ; i++) {
            conn[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            int two = 1;
            Set<Integer> friend = new HashSet<>(); //存已找到朋友
            friend.add(i+1);
            friend.add(conn[i]);
            for (int j = 1; j < n; j++) {
                if (i == j || friend.contains(j+1) || friend.contains(conn[j])) continue;
                friend.add(j+1);
                friend.add(conn[j]);
                two++;
            }
            res = Math.max(res, two);
        }
        System.out.println(res);
    }
}
