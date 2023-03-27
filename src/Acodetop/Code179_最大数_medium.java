package Acodetop;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author 松鼠
 * @data 2022/3/10 17:48
 */
public class Code179_最大数_medium {

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
    }

    //贪心的解法
    public String largestNumber1(int[] nums) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = nums[i] + "";
        }

        //这里是贪心
        //如果拼接结果 ab 要比 ba 好，那么我们会认为 a 应该放在 b 前面。
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o2 + o1;
                String str2 = o1 + o2;
                return str1.compareTo(str2);
            }
        });

        for (String s : str) {
            stringBuffer.append(s);
        }

        int index = 0;
        for (int i = 0; i < stringBuffer.length(); i++) {
            if(stringBuffer.charAt(i) != '0'){
                break;
            }
            index++;
        }
        if(index == stringBuffer.length())
            return "0";

        return stringBuffer.toString().substring(index , stringBuffer.length());
    }


    //快排实现
    public String largestNumber2(int[] nums) {
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
