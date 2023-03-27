package 提升班.第四节课_滑动窗口和单调栈;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Author:松鼠
 * Date:2021/8/29 13:21
 */
public class Code02_MonotonousStack {
    public static void main(String[] args) {
        int[] arr = {0,7,1,2,6,5,3,4};
        int[][] recentMax = getRecentMaxNoRepeat(arr);
//        print(recentMax);

        int[] arr1 = {0,7,1,1,8,6,4,5,5,3,2};
        int[][] recentMax1 = getRecentMax(arr1);
        print(recentMax1);
    }


    /**
     * 适用于 arr 中没有重复的数
     * @param arr
     * @return
     */
    public static int[][] getRecentMaxNoRepeat(int[] arr){
        if(arr == null)
            return null;
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>(); //存的是数组的下标
        stack.push(0);
        for (int i = 1; i < arr.length ; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]){ //栈不为空 且 当前数大于栈顶的数
                Integer pop = stack.pop();
                res[pop][0] = stack.isEmpty() == true ? -1 : arr[stack.peek()];
                res[pop][1] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            res[pop][0] = stack.isEmpty() == true ? -1 : arr[stack.peek()];
            res[pop][1] = -1;
        }

        return res;
    }


    /**
     * 适用于 arr 有重复值的
     * @param arr
     * @return
     */
    public static int[][] getRecentMax(int[] arr){
        if(arr == null)
            return null;
        int[][] res = new int[arr.length][2];
        Stack<LinkedList<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length ; i++) {
            while (!stack.isEmpty() && arr[stack.peek().getLast()] < arr[i]){
                LinkedList<Integer> pop = stack.pop();
                while (!pop.isEmpty()){
                    Integer removeFirst = pop.removeFirst();
                    res[removeFirst][0] = stack.isEmpty() == true ? -1 : arr[stack.peek().getLast()];
                    res[removeFirst][1] = arr[i];

                }
            }
            if(!stack.isEmpty() && arr[stack.peek().getLast()] == arr[i]){
                stack.peek().add(i);
            }else {
                LinkedList<Integer> newList = new LinkedList<>();
                newList.add(i);
                stack.add(newList);
            }
        }

        while (!stack.isEmpty() ){
            LinkedList<Integer> pop = stack.pop();
            while (!pop.isEmpty()){
                Integer removeFirst = pop.removeFirst();
                res[removeFirst][0] = stack.isEmpty() == true ? -1 : arr[stack.peek().getLast()];
                res[removeFirst][1] = -1;

            }
        }
        return res;
    }


    public static void print(int[][] arr){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
