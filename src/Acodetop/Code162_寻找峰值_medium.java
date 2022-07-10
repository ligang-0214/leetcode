package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 17:47
 */
public class Code162_寻找峰值_medium {

    //这题有个条件  规定 nums[-1] = nums[n] = -∞
    //如果测试用例为 1，7，2，3，4，5，6，7，8，9   那按照解法  返回最后一位也行
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (; left < right; ) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) { //这里mid不用判断是否出界  因为mid是偏向left的  所以在for循环中mid+1就不会出界
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
