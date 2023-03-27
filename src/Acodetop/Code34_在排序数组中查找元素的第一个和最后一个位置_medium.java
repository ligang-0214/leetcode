package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 14:51
 */
public class Code34_在排序数组中查找元素的第一个和最后一个位置_medium {

    //看见时间复杂度为 O(log n)   就直接想到二分法
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1 ,-1};
        if(nums == null || nums.length == 0)
            return res;
        int left = 0;
        int right = nums.length -1;
        while (left <= right){ //这里要加 =  否则 用例：[1]   1   无法通过
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                int leftIndex = mid;
                int rightIndex = mid;
                while (leftIndex >= 0 && nums[leftIndex] == target){
                    leftIndex--;
                }
                res[0] = leftIndex + 1;
                while (rightIndex < nums.length && nums[rightIndex] == target){
                    rightIndex++;
                }
                res[1] = rightIndex - 1 ;
                return res;
            }else if(nums[mid] < target){
                left = mid+1;
            }else {
                right = mid -1;
            }

        }
        return res;
    }

}
