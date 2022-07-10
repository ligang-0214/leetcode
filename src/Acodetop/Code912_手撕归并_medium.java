package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/18 20:29
 */
public class Code912_手撕归并_medium {

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length < 2){
            return nums;
        }
        mergeSort(nums , 0 , nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if(left == right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(nums , left , mid);
        mergeSort(nums , mid + 1 , right);
        partition(nums , left , mid , right);
    }

    private void partition(int[] nums, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0; // help数组下标
        int p1 = left; //指向第一段要合并的开头
        int p2 = mid+1; //指向第二段要合并的开头
        while (p1 <= mid && p2 <= right){
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid){
            help[i++] = nums[p1++];
        }
        while (p2 <= right){
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[left + j] = help[j];
        }
    }

}
