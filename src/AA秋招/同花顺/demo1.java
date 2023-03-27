package AA秋招.同花顺;


import java.util.Arrays;

/**
 * @author 松鼠
 * @data 2022/9/16 20:14
 */
public class demo1 {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,8,0,6,7,9};
        int[] process = process(nums);
        System.out.println(Arrays.toString(process));
    }

    public static int[] process(int[] nums){
        int len = nums.length;
        int index;
        for (int i = 0; i < len; i++) {
            index = i;
            for (int j = i + 1; j < len; j++) {
                if(nums[j] < nums[index]){
                    index = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }
}
