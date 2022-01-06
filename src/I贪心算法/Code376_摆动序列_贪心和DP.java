package I贪心算法;

/**
 * @author 松鼠
 * @data 2022/1/6 15:50
 */
public class Code376_摆动序列_贪心和DP {

    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums.length;
        }

        int curDiff = 0; //当前差值
        int preDiff = 0; //上一个差值
        int res = 1; //结果初始化为1  举个简单例子就可以明白【2，5】
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];
            //这里不用想为什么带 = ，等于0的情况表示初始时的preDiff
            //只要经过一轮变化之后  preDiff 一定是或正或负
            if( (preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0) ){
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

}
