package Acodetop;

/**
 * @author 松鼠
 * @data 2022/6/30 22:37
 */
public class Code287_寻找重复数_medium {

    //https://leetcode.cn/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
    // 二分法  时间：O(N*logN)
    // 如果题目不设要求  也可以用原地哈希法
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if(num <= mid){
                    count++;
                }
            }
            if(count > mid){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

}
