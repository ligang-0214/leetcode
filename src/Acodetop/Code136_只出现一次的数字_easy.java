package Acodetop;

/**
 * @author 松鼠
 * @data 2022/3/2 16:07
 */
public class Code136_只出现一次的数字_easy {

    /**
     * 异或运算
     * A异或A=0，A异或0=A
     * 异或运算满足交换律和结合率
     * A^A^B^B^C^C^D = 0^D = D  找到数字D为答案
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

}
