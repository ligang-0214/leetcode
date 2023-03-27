package AInterview.bytedance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/27 18:59
 */
public class zj4 {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<HashSet<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            HashSet<Integer> tempList = new HashSet<>();
            for (int j = 0; j < temp; j++) {
                tempList.add(sc.nextInt());
            }
            nums.add(tempList);
        }
        for (int i = 0; i < nums.size(); i++) {
            process(nums.get(i) , n , nums);
        }
        System.out.println(res == Integer.MAX_VALUE ? 0 : res);
    }

    private static void process(HashSet<Integer> set, int n , ArrayList<HashSet<Integer>> nums) {
        HashSet<Integer>  in = new HashSet<>();
        in.addAll(set);
        int temp = 0;
        while (in.size() < n && temp != n){
            HashSet<Integer> tempSet = new HashSet<>(in);
            for (Integer integer : tempSet) {
                in.addAll(nums.get(integer - 1));
            }
            temp++;
        }
        if(temp == n)
            return;
        else {
            res = Math.min(res , temp);
        }
    }
}
