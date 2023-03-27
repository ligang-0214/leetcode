package Acodetop;

/**
 * @author 松鼠
 * @data 2022/2/21 17:12
 */
public class Code53_最大子数组和_easy {

    public int maxSubArray1(int[] nums) {
       if(nums.length == 1){
           return nums[0];
       }

       int preMax = nums[0];
       int res = nums[0];
       for (int i = 1; i < nums.length; i++) {
           if(preMax <= 0 ){
               preMax = nums[i];
           }else {
               preMax += nums[i];
           }
           res = Math.max(res , preMax);
       }
       return res;
    }

    public int maxSubArray2(int[] nums){
        int preSum = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums){
            preSum = Math.max(preSum + num , num);
            res = Math.max(preSum , res);
        }
        return res;
    }


}
