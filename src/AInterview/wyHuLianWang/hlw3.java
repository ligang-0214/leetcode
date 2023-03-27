package AInterview.wyHuLianWang;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/27 15:29
 */
public class hlw3 {
    static  ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> temp = new ArrayList<>();
        process(temp  , n);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }

    private static void process(ArrayList<Integer> temp, int n) {
        if(res.size() > 0){
            return;
        }
        if(temp.size() > 1 && (temp.get(temp.size() - 1) * temp.get((temp.size() - 2) / 2)) % 2 != 0){
            return;
        }
        if(temp.size() == n){
            res = new ArrayList<>(temp);
            return;
        }
        Random random = new Random();
        int i = random.nextInt(n) + 1;
        while (temp.contains(i)){
            i = random.nextInt(n) + 1;
        }
        temp.add(i);
        process(temp , n);
        temp.remove(temp.size() - 1);
//        for (int i = 1; i <= n; i++) {
//            if(temp.contains(i)){
//                continue;
//            }
//            temp.add(i);
//            process(temp , n);
//            temp.remove(temp.size() - 1);
//        }
    }
}
