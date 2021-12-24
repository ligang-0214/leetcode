package F栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 松鼠
 * @data 2021/12/22 10:05
 */
public class Code739_每日温度 {
    public static void main(String[] args) {
        int[] temperature = {55,38,53,81,61,93,97,32,43,78};
        int[] temperature1 = {34,80,80,34,34,80,80,80,80,34};
        System.out.println(Arrays.toString(dailyTemperatures(temperature1)));
    }



    /**
     * 解法一：暴力解法  但是时间特别长   哈哈哈哈哈哈
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if(temperatures[j] > temperatures[i]){
                    res[i] =  j - i;
                    break;
                }
            }
        }
        return res;

    }

    /**
     * 解法二：使用栈的方式 好好好啊！！！
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            //如果栈不为空  就会将小于当前元素的所有值都弹出  并且记录结果
            while(stack.isEmpty() == false && temperatures[i] > temperatures[stack.peek()]){
                Integer pop = stack.pop();
                res[pop] = i - pop;
            }
            //栈为空  或者新遍历到的值小于栈顶
            stack.add(i);
        }
        return res;

    }




}
