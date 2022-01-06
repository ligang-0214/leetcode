package I贪心算法;

/**
 * @author 松鼠
 * @data 2022/1/6 19:10
 */
public class Code55_跳跃游戏 {

    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        if(nums[0] == 0) //处理第一个位置为0的情况
            return false;

        int maxIndex = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(maxIndex < i) // 防止中间有些位置就已经不可达  就不用再往下走了
                return false;
            int temp = i + nums[i];
            maxIndex = Math.max(temp,maxIndex);
            if(maxIndex >= nums.length - 1)
                return true;
        }
        return false;
    }

}
