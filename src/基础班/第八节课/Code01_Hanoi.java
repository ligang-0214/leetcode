package 基础班.第八节课;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:松鼠
 * Date:2021/7/20 16:37
 */
public class Code01_Hanoi {
    public static void main(String[] args) {
        int n = 3;
        hanoi(n);


        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        hanota(A,B,C);

    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        process(A.size() , A , B , C );
    }

    public static void process(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        if(n == 1){
            C.add(A.remove(A.size() - 1));
            return ;
        }
        process(n - 1,A,C,B);
        C.add(A.remove(A.size() - 1));
        process(n - 1,B,A,C);
    }



    public static void hanoi(int n) {
        if (n > 0) {
            func(n, "left", "mid", "right");
        }
    }

    public static void func(int rest, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("Move 1"+ " from " + from + " to " + to);
            return;
        }
        //将 1~i-1 从from挪到help上去
        func(rest - 1, from, to, help);
        //将 i 从from挪到to上去
        System.out.println("Move "+ rest + " from " + from + " to " + to);
        //将 1~i-1 从help挪到to上去
        func(rest - 1, help, from, to);
    }

}
