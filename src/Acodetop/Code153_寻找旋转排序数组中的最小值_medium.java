package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 15:08
 */
public class Code153_寻找旋转排序数组中的最小值_medium {

    //其实本质就是二分法
    //力扣33题和这个有点类似   牛客的BM21 对这题进行了改进  可以允许有重复数字  以及 offer11也是允许有重复值
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;                /* 左闭右闭区间，如果用右开区间则不方便判断右值 */
        while (left < right) {                      /* 循环不变式，如果left == right，则循环结束 */
            int mid = left + (right - left) / 2;    /* 地板除，mid更靠近left */
            if (nums[mid] > nums[right]) {          /* 中值 > 右值，最小值在右半边，收缩左边界 */
                left = mid + 1;                     /* 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid */
            } else if (nums[mid] < nums[right]) {   /* 明确中值 < 右值，最小值在左半边，收缩右边界 */
                right = mid;                        /* 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处 */
            }
        }
        return nums[left];    /* 循环结束，left == right，最小值输出nums[left]或nums[right]均可 */
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
