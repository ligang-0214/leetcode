package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/22 15:50
 */
public class Code33_搜索旋转排序数组_medium {

    public static void main(String[] args) {
        int[] a = {1,3};
        search(a , 3);
    }


    //二分查找  跟153有点类似
    public static int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 1) {
            return target == nums[0] ? 0 : -1;
        }

        int left = 0;
        int right = length - 1;
        while (left <= right) {

            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[right]) { // 如果右半部分是有序的
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;

    }

}
