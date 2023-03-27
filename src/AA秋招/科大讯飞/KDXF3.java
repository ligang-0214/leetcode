package AA秋招.科大讯飞;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/7/23 20:37
 */
public class KDXF3 {


    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> temp = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tempList.add(sc.nextInt());
        }
        backtracking();

    }

    private static void backtracking() {
        if(temp.size() == 5){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < 5; i++) {

        }

    }

}
