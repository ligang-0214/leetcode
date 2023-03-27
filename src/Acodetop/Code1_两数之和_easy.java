package Acodetop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/2/21 16:35
 */
public class Code1_两数之和_easy {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0] , 0);
        int[] res = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i] , i);
        }
        return res;

    }
}
