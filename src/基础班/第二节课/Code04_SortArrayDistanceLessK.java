package 基础班.第二节课;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Author:松鼠
 * Date:2021/6/4 14:07
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元
 * 素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的
 * 排序算法针对这个数据进行排序。
 */
public class Code04_SortArrayDistanceLessK {

	public static void main(String[] args) {
		int[] arr={2,3,8,9,7,5,6,3,4,1,2,9,8,5};//这个数据是不能用的  因为并不满足题目要求的数据
		int[] arr1={2,3,8,9,1,5,10,6};
		sortedArrDistanceLessK(arr1,4);
		System.out.println(Arrays.toString(arr1));
	}

	public static void sortedArrDistanceLessK(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>(); //默认是一种小根堆结构
		int index = 0;
		for (; index <= Math.min(arr.length, k); index++) {//把0-k的数先放进小根堆中
			heap.add(arr[index]);
		}
		int i = 0;
		for (; index < arr.length;  i++, index++) {
			heap.add(arr[index]);//把剩下的数依次放进小根堆中 那第一个数一定是最小的
			arr[i] = heap.poll();//把最小的拿出来
		}
		while (!heap.isEmpty()) {
			arr[i++] = heap.poll();
		}
	}
}
