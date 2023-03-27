package A数组;



/**
 * Author:松鼠
 * Date:2021/9/16 10:51
 */
public class Code209_长度最小的子数组 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen1(7,arr));
    }

    /**
     * 我觉得我这也算是滑动窗口
     * 每次以target为标准，不够就右窗口往后括  超过target就左窗口缩小 缩小前更新一下res
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen1(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int temp = 0;
        int res = Integer.MAX_VALUE;
        while (target <= temp || r < nums.length){
            if(temp < target ){
                temp += nums[r];
                r++;
            }else {
                res = (r - l) < res ? (r - l) : res;
                temp -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    /**
     * 每次窗口右边就往前括  括完之后再统一循环 考虑左窗口的缩小问题
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen2(int target, int[] nums){
        int l = 0;
        int temp = 0;
        int res = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length ; r++) {
            temp += nums[r];
            while (temp >= target){
                res = (r - l + 1) < res ? (r - l + 1) : res;
                temp -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }

}
