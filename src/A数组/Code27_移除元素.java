package A数组;

import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/9/15 17:06
 */
public class Code27_移除元素 {
    public static void main(String[] args) {
        int[] arr = {2,1,0,2,2,4,5,6,2};
        System.out.println(removeElement1(arr,2));
        System.out.println(removeElement2(arr,2));
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param nums
     * @param val
     * @return 返回值代表移除后的数组长度
     */
    public static int removeElement1(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int flag = nums.length;
        for (int i = 0; i < flag ; i++) {
            if(nums[i] == val){
                for (int j = i+1 ; j < flag ; j++) {
                    nums[j-1] = nums[j];
                }
                // 因为原本i位置的值已经被移除了 此时位置是新值
                // 如果不--  for循环就会往后跳 这一位就没检验
                //这两句位置别放错了  我之前放到if判断的外面。。。。
                i--;
                flag--;
            }
        }
        return flag;
    }


    /**
     * 双指针的方式  我刚开始写没写出来。。。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    public static int removeElementPractice(int[] nums, int val){
        if(nums.length == 0)
            return 0;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
