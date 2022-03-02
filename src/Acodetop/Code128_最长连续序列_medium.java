package Acodetop;

import java.util.HashSet;

/**
 * @author 松鼠
 * @data 2022/3/2 16:11
 */
public class Code128_最长连续序列_medium {

    //直接看题解  很巧妙
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            if(!set.contains(num - 1)){
                int flag = 1;
                int temp = num;
                while (set.contains(temp + 1)){
                    temp++;
                    flag++;
                }
                res = Math.max(res , flag);
            }
        }
        return res;
    }

}
