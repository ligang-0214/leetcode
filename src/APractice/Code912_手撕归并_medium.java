package APractice;

/**
 * @author 松鼠
 * @data 2022/7/9 16:27
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
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(nums , left , mid);
            mergeSort(nums , mid + 1 , right);
            process(nums , left , mid , right);
        }
    }

    private void process(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right){
            if(nums[leftIndex] <= nums[rightIndex]){
                temp[index++] = nums[leftIndex++];
            }else{
                temp[index++] = nums[rightIndex++];
            }
        }
        while (leftIndex <= mid){
            temp[index++] = nums[leftIndex++];
        }
        while (rightIndex <= right){
            temp[index++] = nums[rightIndex++];
        }
        index = 0;
        for (int i = left; i <= right; i++) {
            nums[i] = temp[index++];
        }
    }


}
