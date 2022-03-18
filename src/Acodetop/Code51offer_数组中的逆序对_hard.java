package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/15 15:16
 */
public class Code51offer_数组中的逆序对_hard {

    int res = 0;
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2){
            return res;
        }
        mergeSort(nums , 0 , nums.length - 1);
        return res;
    }
    public void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0; //help数组的下标
        int p1 = l; //指向第一段要合并的开头
        int p2 = m + 1; //指向第二段要合并的开头
        while (p1 <= m && p2 <= r) {
            if(arr[p1] <= arr[p2]){
                help[i++] = arr[p1++];
            }else {
                res += m - p1 + 1;
                help[i++] = arr[p2++];
            }
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
