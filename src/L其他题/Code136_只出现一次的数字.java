package L其他题;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * @author 松鼠
 * @data 2021/12/21 19:20
 */
public class Code136_只出现一次的数字 {
    public static void main(String[] args) {

    }


    /**
     * 解法一：使用哈希表的解法  虽然时间复杂度满足  但需要空间复杂度
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.remove(nums[i]);
            }else {
                map.put(nums[i],1);
            }
        }
        int res = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            res = entry.getKey();
        }
        return res;
    }


    /**
     * 解法二：异或运算
     * A异或A=0，A异或0=A
     * 异或运算满足交换律和结合率
     * A^A^B^B^C^C^D = 0^D = D  找到数字D为答案
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums){

        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }


    /**
     * 解法三：两次for循环  暴力解法
     */


    /**
     * 解法四：使用快排  然后可以二分查找 因为此时某个元素  只要它的左右两边没有相等的元素  那它就一定是答案
     *
     * 阿里之前有个问题：给的是有序数组，然后问如何时间复杂度为O(logN) 来实现这题
     *          就可以使用二分的办法，然后和左右两边比较是否有相等的元素
     */





}
