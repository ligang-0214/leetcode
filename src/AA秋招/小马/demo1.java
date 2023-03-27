package AA秋招.小马;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 松鼠
 * @data 2022/9/16 20:34
 */
public class demo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long K = sc.nextLong();
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            list.addLast(new int[]{temp, i});
        }
        while (K-- >= 0) {
            int[] first = list.removeFirst();
            if (first[0] == 0) {
                list.addLast(first);
                continue;
            }
            list.addLast(new int[]{first[0] - 1, first[1]});
        }
        System.out.println(list.getFirst()[1] + 1);


    }

}
