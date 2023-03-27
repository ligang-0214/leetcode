package I贪心算法;

/**
 * @author 松鼠
 * @data 2022/1/6 19:25
 */
public class Code45_跳跃游戏二 {

    //题目保证一定会打到最后一个位置
    public int jump(int[] nums) {
        int res = 0;
        int curMaxIndex = 0; // 当前可到达的最大位置
        int nextMaxIndex = 0; //如果当前这一次不能跳到最后一个位置  这个参数就代表下次可到达的最远距离
        for (int i = 0; i < nums.length - 1; i++) {
            nextMaxIndex = Math.max(nextMaxIndex,nums[i] + i);
            if(i == curMaxIndex){ // 如果i走到了上一次可到达的最远距离 还没到终点的话 就会增加一步
                curMaxIndex = nextMaxIndex;
                res++;
            }
        }
        return res;
    }

}
