package Acodetop;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 松鼠
 * @data 2022/3/10 17:48
 */
public class Code179_最大数_medium {

    public String largestNumber(int[] nums) {
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

}
