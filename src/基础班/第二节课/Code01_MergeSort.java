package 基础班.第二节课;

import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/6/23 16:20
 */
public class Code01_MergeSort {
    public static void main(String[] args) {
        int[] arr1=new int[]{3,5,6,3,4,5,2,6,9,0};
        mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;  //此时就只有一个数  就不需要排序了
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0; //help数组的下标
        int p1 = l; //指向第一段要合并的开头
        int p2 = m + 1; //指向第二段要合并的开头
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
