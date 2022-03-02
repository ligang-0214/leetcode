package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 15:08
 */
public class Code153_寻找旋转排序数组中的最小值_medium {

    //自己想出来的解法  其实本质就是二分法  33题和这个有点类似
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            if((right - left) == 1){
                return Math.min(nums[left] , nums[right]);
            }
            int mid = left + (right - left ) / 2;
            if(nums[mid] > nums[right] && nums[mid] > nums[left]){
                left = mid;
            }else if(nums[mid] < nums[right] && nums[mid] < nums[left]){
                right = mid;
            }else {
                right = mid;
            }
        }
        return nums[0];
    }

}
