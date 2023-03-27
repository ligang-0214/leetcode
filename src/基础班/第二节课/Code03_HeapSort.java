package 基础班.第二节课;

import java.util.Arrays;

public class Code03_HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		//这个时间复杂度会高一点
//		for (int i = 0; i < arr.length; i++) {//把给的数组从前往后遍历 从下往上比较变成大根堆
//			heapInsert(arr, i);
//		}
		//这个方法时间复杂度会低一点
		for (int i = arr.length-1; i > 0; i--) {//把给的数组从后往前遍历 从上往下比较变成大根堆
			heapify(arr,i,arr.length);
		}

		int size = arr.length;
		swap(arr, 0, --size); //把最大的与最后一位置换   最后一位就确定了
		while (size > 0) {  //直到size为0的时候  整个数组就都有序了  是从后往前一位一位确定的
			heapify(arr, 0, size);
			swap(arr, 0, --size);
		}
	}

	/**
	 * 往上比较   生成大根堆/大顶堆
	 * @param arr
	 * @param index
	 */
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) /2);
			index = (index - 1)/2 ;
		}
	}

	/**
	 * 往下比较  把较小的往下放
	 * @param arr
	 * @param index
	 * @param size
	 */
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1; //左孩子
		while (left < size) { //如果存在左孩子
			//这句写得非常简洁、非常好   获取左、右孩子种较大的
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			//较大的孩子和父结点作比较  如果比孩子小就要置换
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1; //接着获取更改后的左孩子
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}
