package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/21 15:33
 */
public class Code912_手撕快排_medium {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l < r){
            swap(arr,l + (int)Math.random()*(r-l+1), r);
            int[] leftAndRightIndex = partition(arr , l , r);
            quickSort(arr , l , leftAndRightIndex[0] - 1);
            quickSort(arr , leftAndRightIndex[1] + 1 , r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int lFlag = l - 1;
        int rFlag = r;
        while (l < rFlag){
            if(arr[l] < arr[r]){
                swap(arr,++lFlag,l++);
            }else if(arr[l] > arr[r]){
                swap(arr , l , --rFlag);
            }else {
                l++;
            }
        }
        swap(arr,rFlag,r);
        return new int[]{l , rFlag};
    }


    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
