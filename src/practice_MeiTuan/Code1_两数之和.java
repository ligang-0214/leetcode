package practice_MeiTuan;

import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/3/29 20:29
 */
public class Code1_两数之和 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                res[0] = map.get(temp);
                res[1] = i;
                break;
            }else {
                map.put(nums[i] , i);
            }
        }
        return res;
    }

}
