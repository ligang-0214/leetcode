package Acodetop;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 松鼠
 * @data 2022/3/18 22:29
 */
public class Code45offer_把数组排成最小的数_medium {

    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = nums[i] + "";
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });

        StringBuffer buffer = new StringBuffer();
        for (String s : str) {
            buffer.append(s);
        }
        return buffer.toString();
    }

}
