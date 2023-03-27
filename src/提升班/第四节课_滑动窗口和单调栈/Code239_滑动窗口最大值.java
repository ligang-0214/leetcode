package 提升班.第四节课_滑动窗口和单调栈;

import java.util.LinkedList;

/**
 * Author:松鼠
 * Date:2021/8/29 13:14
 */
public class Code239_滑动窗口最大值 {


    public int[] maxSlidingWindow(int[] arr, int w) {
        if(arr.length < w){
            return new int[]{};
        }
        int[] res = new int[arr.length - w + 1];
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        //先放入前w个数在双端队列中
        for (int i = 1; i < w; i++) {
            while (!list.isEmpty() && arr[list.getLast()] <= arr[i]){
                list.removeLast();
            }
            list.add(i);
        }
        res[0] = arr[list.getFirst()];
        int L = 0;
        int flag = 0;
        for (int R = w ; R < arr.length ; R++) {
            while (!list.isEmpty() && arr[list.getLast()] <= arr[R]){
                list.removeLast();
            }
            list.add(R);
            if(list.getFirst() == L++){
                list.removeFirst();
            }
            res[++flag] = arr[list.getFirst()];
        }
        return res;

    }

}
