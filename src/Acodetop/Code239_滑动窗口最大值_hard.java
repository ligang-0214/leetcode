package Acodetop;

import java.util.LinkedList;

/**
 * @author 松鼠
 * @data 2022/2/26 10:45
 */
public class Code239_滑动窗口最大值_hard {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{7,2 ,4} , 2);
    }


    public static  int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        for (int i = 1; i < k; i++) {
            while (!linkedList.isEmpty() && nums[i] >= nums[linkedList.getLast()]) {
                linkedList.removeLast();
            }
            linkedList.addLast(i);
        }
        res[0] = nums[linkedList.getFirst()];
        int L = 0;
        int flag = 1;
        for (int i = k; i < nums.length; i++) {
            while (!linkedList.isEmpty() && nums[i] >= nums[linkedList.getLast()]) {
                linkedList.removeLast();
            }
            linkedList.addLast(i);
            if(linkedList.getFirst() == L){
                linkedList.removeFirst();
            }
            L++;
            res[flag++] = nums[linkedList.getFirst()];
        }
        return res;
    }

}
