package A数组;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author:松鼠
 * Date:2021/9/16 9:48
 */
public class Code283_移动零 {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String s = sc.nextLine();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        System.out.println(list.toString());

    }

    public static void moveZeroes(int[] nums) {
        if(nums.length == 0)
            return ;
        int slow = 0;
        for(int fast = 0; fast < nums.length ; fast++){
            if(nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
        }
        for( ;slow < nums.length ; slow++){
            nums[slow] = 0;
        }
    }
}
