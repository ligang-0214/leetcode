package APractice;

import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/7/9 16:57
 */
public class Code179_最大数_medium {

    // 使用快排来做
    public String largestNumber(int[] nums) {
        quickSort(nums , 0 , nums.length - 1);
        if(nums[0] == 0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();

    }

    private void quickSort(int[] nums, int left, int right) {
        if(left < right){
            swap(nums , left + new Random().nextInt(right - left) , right);
            int[] temp = process(nums , left , right);
            quickSort(nums , left , temp[0] - 1);
            quickSort(nums , temp[1] + 1 , right);
        }
    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }

    private int[] process(int[] nums, int left, int right) {
        int leftIndex = left - 1;
        int rightIndex = right;
        while (left < rightIndex){
            /*比如：int x = 12; int y = 345
            x 拼接 y = 12345 = 12 * 1000 + 345 = x * 1000 + y;
            y 拼接 x = 34512 = 345 * 100 + 12 = y * 100 + x;
            上面的1000是哪里来的？因为y是3位数。上面的100是哪里来的？因为x是2位数；明白这个思想就能写出代码了*/
            long x = 10;
            long y = 10;
            while (nums[left] >= x) {
                x *= 10;
            }
            while (nums[right] >= y) {
                y *= 10;
            }
            if(nums[left] * y + nums[right] > nums[right] * x + nums[left]){
                swap(nums , left++ , ++leftIndex);
            }else if(nums[left] * y + nums[right] < nums[right] * x + nums[left]){
                swap(nums , left , --rightIndex);
            }else {
                left++;
            }
        }
        swap(nums , right , left);
        return new int[]{leftIndex + 1 , rightIndex};
    }


}
