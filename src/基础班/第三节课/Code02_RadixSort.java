package 基础班.第三节课;

import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/6/4 19:52
 */
public class Code02_RadixSort {
    public static void main(String[] args) {
        int[] arr={12,2,4,85,7,698,46,12,54,3,4527};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    /**
     * 获取最大的数的位数
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * 基数排序
     * @param arr
     * @param begin
     * @param end
     * @param digit
     */
    public static void radixSort(int[] arr, int begin, int end, int digit) {
        final int radix = 10;  //以10为基底   10进制
        int i = 0, j = 0;
        //有多少个数就准备多少辅助空间 用来存最后结果的
        int[] bucket = new int[end - begin + 1];
        for (int d = 1; d <= digit; d++) { //有多少位就循环几次
            int[] count = new int[radix]; //充当桶的作用
            //记录第d位上出现各个数字的个数  比如：个位上为5出现2次 那么最后count[5]=2
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            //count[i]为前面数组之和
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //从后往前遍历  因为相同一个桶内 后入桶的要后出桶 所以就先处理掉
            for (i = end; i >= begin; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = begin, j = 0; i <= end; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    /**
     * 获取x的第d位上的数字
     * @param x
     * @param d
     * @return
     */
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }
}
