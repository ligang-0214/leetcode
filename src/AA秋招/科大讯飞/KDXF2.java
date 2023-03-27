package AA秋招.科大讯飞;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/7/23 20:14
 */
public class KDXF2 {
    static int res = 0;
    static LinkedList<ArrayList<Integer>> points = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(x);
            temp.add(y);
            list.add(temp);
        }
        backtracking(list, 0);
        System.out.println(res);
    }

    private static void backtracking(ArrayList<ArrayList<Integer>> list, int index) {
        if(points.size() > 3){
            return;
        }
        if (points.size() == 3 && check(points)) {
            res++;
            return;
        }
        if(3 - points.size() > list.size() - index){
            return;
        }
        for (int i = index; i < list.size(); i++) {
            points.addLast(list.get(i));
            backtracking(list, i + 1);
            points.removeLast();
        }
    }

    private static boolean check(LinkedList<ArrayList<Integer>> points) {
        ArrayList<Integer> l1 = points.get(0);
        ArrayList<Integer> l2 = points.get(1);
        ArrayList<Integer> l3 = points.get(2);
        double temp1 = Math.pow((l2.get(0) - l1.get(0)), 2) + Math.pow((l2.get(1) - l1.get(1)), 2);
        double temp2 = Math.pow((l3.get(0) - l2.get(0)), 2) + Math.pow((l3.get(1) - l2.get(1)), 2);
        double temp3 = Math.pow((l1.get(0) - l3.get(0)), 2) + Math.pow((l1.get(1) - l3.get(1)), 2);
        if (temp1 + temp2 == temp3 || temp2 + temp3 == temp1 || temp3 + temp1 == temp2) {
            return true;
        }
        return false;
    }
}
