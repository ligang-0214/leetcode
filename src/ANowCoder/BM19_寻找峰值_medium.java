package ANowCoder;

/**
 * @author 松鼠
 * @data 2022/6/27 9:53
 */
public class BM19_寻找峰值_medium {

    public int findPeakElement (int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

}
