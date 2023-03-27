package C哈希表;

import java.util.HashMap;

/**
 * @author 松鼠
 * @data 2022/6/23 10:26
 */
public class Code39offer_数组中出现次数超过一半的数字 {

    //map的方式  时间：O(N)  空间：O(N)
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                Integer temp = map.get(nums[i]);
                map.put(nums[i] , temp+1);
                if(temp+1 > nums.length /2)
                    return nums[i];
            }else {
                map.put(nums[i] , 1);
            }
        }
        return nums[0]; // 因为可能nums中只存在一个元素
    }

    // 摩尔投票法   可以的  感觉像脑筋急转弯    时间：O(N)  空间：O(1)
    public int majorityElement2(int[] nums) {
        int pre = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                pre = nums[i];
            }
            if(pre == nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return pre;

    }

}
