package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 15:08
 */
public class Code153_寻找旋转排序数组中的最小值_medium {

    //自己想出来的解法  其实本质就是二分法
    //力扣33题和这个有点类似   牛客的BM21 对这题进行了改进  可以允许有重复数字
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

    //牛客 BM21
    public int minNumberInRotateArray(int [] array) {
        int l = 0;
        int r = array.length - 1;

        while(l < r){
            if(r - l == 1){
                return Math.min(array[l] , array[r]);
            }
            int m = l + (r - l)/2;
            if(array[m] > array[r]){
                l = m;
            }else if(array[m] < array[l]){
                r = m;
            }else{
                r--;
            }
        }
        return array[l];
    }

}
