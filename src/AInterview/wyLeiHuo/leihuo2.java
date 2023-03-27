package AInterview.wyLeiHuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/26 13:56
 */
public class leihuo2 {
    static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        //输入M组数据
        for (int i = 0; i < M; i++) {
            int N = sc.nextInt();
            Integer[] nums = new Integer[N];
            for (int j = 0; j < N; j++) {
                nums[j] = sc.nextInt();
            }
            sc.nextLine();//消化一个回车符
            String[]  words = sc.nextLine().split(" ");
            process(nums , words , N);
        }
        for (Integer re : res) {
            System.out.println(re);
        }
    }

    private static void process(Integer[] nums, String[] words, int N) {
        Arrays.sort(nums);
        Arrays.sort(words);
        if(N == 5){
            if(five(nums , words) == 1)
                return;
            if(four(nums , words) == 1)
                return;
            if(three(nums , words) == 1)
                return;
            if(two(nums , words) == 1)
                return;
            res.add(1);
            return;
        }else if(N == 4){
            if(four(nums , words) == 1)
                return;
            if(three(nums , words) == 1)
                return;
            if(two(nums , words) == 1)
                return;
            res.add(1);
            return;
        }else if(N == 3){
            if(three(nums , words) == 1)
                return;
            if(two(nums , words) == 1)
                return;
            res.add(1);
            return;
        }else if(N == 2){
            if(two(nums , words) == 1)
                return;
            res.add(1);
            return;
        }else {
            res.add(1);
        }
    }

    private static int two(Integer[] nums, String[] words) {
        int len = nums.length;
        if(nums[0] == nums[len - 1]){
            res.add(2);
            return 1;
        }
        return -1;
    }

    private static int three(Integer[] nums, String[] words) {
        int len = nums.length;
        if(nums[0] == nums[len - 1]){
            res.add(6);
            return 1;
        }
        return -1;

    }

    private static int four(Integer[] nums, String[] words) {
        int len = nums.length;
        if(nums[0] == nums[len -1]){
            res.add(150);
            return 1;
        }
        if(nums[0] == nums[1] && nums[2] == nums[3]){
            res.add(4);
            return 1;
        }
        return -1;

    }

    private static int five(Integer[] nums, String[] words) {
        int len = nums.length;
        if(nums[0] == nums[len - 1]){
            res.add(15000);
            return 1;
        }
        if(words[0].charAt(0)==words[len -1].charAt(0) &&
             nums[0] + nums.length - 1 == nums[len -1]){
            res.add(8000);
            return 1;
        }
        if(words[0].charAt(0)==words[len -1].charAt(0)){
            res.add(300);
            return 1;
        }
        if((nums[0] == nums[2] && nums[3] == nums[4]) || (nums[0] == nums[1] && nums[2] == nums[4])){
            res.add(40);
            return 1;
        }
        if(nums[0] + nums.length - 1 == nums[len -1]){
            res.add(20);
            return 1;
        }
        return -1;
    }

}
