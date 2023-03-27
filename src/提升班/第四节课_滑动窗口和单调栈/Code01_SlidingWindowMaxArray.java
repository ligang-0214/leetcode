package 提升班.第四节课_滑动窗口和单调栈;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Author:松鼠
 * Date:2021/8/29 12:01
 */
public class Code01_SlidingWindowMaxArray {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
        int w = 3;
        getMaxWindow(arr, w);
    }

    public static void getMaxWindow(int[] arr , int w){
        if(arr.length < w || w == 0){
            return;
        }
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0); //存的下标
        //先录入前w个数在双端队列中（队列中最少有1个  最多w个  数据）
        for (int i = 1; i < w; i++) {
            while (!list.isEmpty() && arr[list.getLast()] <= arr[i]){
                list.removeLast();
            }
            list.add(i);
        }
        res[0] = arr[list.getFirst()]; //队列的头永远是最大的  取出来用即可
        int L = 0; //窗口的左边界
        int flag = 0;// 记录res的下标
        //窗口的右边界  往右滑动
        for (int R = w ; R < arr.length ; R++) {
            // 添加窗口新的右边界
            while (!list.isEmpty() && arr[list.getLast()] <= arr[R]){
                list.removeLast();
            }
            list.add(R);
            // 查看是否需要取消窗口的左边界
            if(list.getFirst() == L++){
                list.removeFirst();
            }
            res[++flag] = arr[list.getFirst()];
        }
        System.out.println(Arrays.toString(res));

    }

}
