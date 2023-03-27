package 基础班.第二节课;

import java.util.Arrays;
import java.util.Random;

/**
 * Author:松鼠
 * Date:2021/6/2 21:07
 */
public class Code06_QuickSort {
    public static void main(String[] args) {
        int[] arr1=new int[]{3,5,6,3,4,5,2,6,9,0};
        quickSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            //swap(arr, l + (int) (Math.random() * (r - l + 1)), r); //随机选一个数与最后一位置换
            swap(arr, l + new Random().nextInt(r-l), r); //随机选一个数与最后一位置换
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {
        int lflag = l - 1;
        int rflag = r;
        while (l < rflag) { //将当前位置的数与最后一位作比较  大的放前面  小的放后面  等于放中间
            if (arr[l] < arr[r]) {
                swap(arr, ++lflag, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --rflag, l);
            } else {
                l++;
            }
        }
        swap(arr, rflag, r); //因为在置换时  最后一位不能动  所以处理完之后要把最后一位和右边这一堆的第一个置换
        return new int[] { lflag + 1, rflag };
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
