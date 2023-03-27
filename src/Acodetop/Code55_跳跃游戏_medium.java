package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/11 10:26
 */
public class Code55_跳跃游戏_medium {

    public boolean canJump(int[] nums) {
        int maxIndex = nums[0];
        int len = nums.length - 1;
        for (int i = 1; i < len + 1; i++) {
            if(maxIndex >= len){
                return true;
            }
            if(i > maxIndex ){
                return false;
            }
            maxIndex = Math.max(maxIndex , nums[i] + i);
        }
        return true;
    }

}
