package Acodetop;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/2/20 21:10
 */
public class Code215_数组中的第K个最大元素_medium {

    //如果让用priorityQueue就用堆排 不让用,我选择快速排序,时间复杂度o(nlogk)
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; //小根堆
            }
        });
        for (int num : nums) {
            heap.add(num);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }

    // 参考官方题解的思路
    // https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
    // 但是我这个是根据自己的快排改的版本  跟官方题解的写法不太一样
    public int findKthLargest2(int[] nums, int k){
        return quickSort(nums , 0 , nums.length - 1 , nums.length - k);
    }

    private int quickSort(int[] nums, int l, int r, int index) {
        int[] leftAndRightIndex = partition(nums , l , r);
        if(leftAndRightIndex[0] <= index && leftAndRightIndex[1] >= index){
            return nums[index];
        }else if(leftAndRightIndex[1] < index){
            return quickSort(nums , leftAndRightIndex[1] + 1 , r , index);
        }else {
            return quickSort(nums , l , leftAndRightIndex[0] - 1 , index);
        }
    }

    private int[] partition(int[] nums, int l, int r) {
        if(l < r)
            swap(nums , l + new Random().nextInt(r - l) , r);
        int lFlag = l - 1;
        int rFlag = r;
        while (l < rFlag){
            if(nums[l] < nums[r]){
                swap(nums,++lFlag,l++);
            }else if(nums[l] > nums[r]){
                swap(nums , l , --rFlag);
            }else {
                l++;
            }
        }
        swap(nums,rFlag,r);
        return new int[]{lFlag + 1 , rFlag};
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
