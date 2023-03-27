package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/23 16:14
 */
public class Code704_二分查找_easy {
    //可能会考变种
    //如果有重复元素  找到第一个    解决：先二分找到一个  然后向左遍历
    public int search(int[] nums, int target){
        int left = 0 , right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2 ;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;

    }

}
