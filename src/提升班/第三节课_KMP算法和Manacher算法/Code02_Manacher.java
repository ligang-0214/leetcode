package 提升班.第三节课_KMP算法和Manacher算法;


import java.util.Arrays;

/**
 * Author:松鼠
 * Date:2021/8/3 16:45
 */
@SuppressWarnings("all")
public class Code02_Manacher {
    public static void main(String[] args) {
        String str1 = "abc1234321ab";
//        char[] chars = manacherString(str1);
        System.out.println(maxLcpsLength(str1));
    }


    public static char[] manacherString(String str) {
        StringBuffer stringBuffer = new StringBuffer("#");
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(str.charAt(i)).append("#");
        }
        return  stringBuffer.toString().toCharArray();
//        char[] charArr = str.toCharArray();
//        char[] res = new char[str.length() * 2 + 1];
//        int index = 0;
//        for (int i = 0; i != res.length; i++) {
//            res[i] = (i % 2) == 0 ? '#' : charArr[index++];
//        }
//        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str); //将所给的字符串处理一下 1221 ---> #1#2#2#1#
        int[] pArr = new int[charArr.length]; //回文半径数组
        int C = -1; //回文的中心
        int R = -1; //回文右边界的再往右一个位置  所以最右边的有效区是 R-1
        int max = Integer.MIN_VALUE; //扩出来的最大值

        //每个位置都求回文半径
        for (int i = 0; i != charArr.length; i++) {
//            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;  //我拆开写了  方便理解
            //情况一
            if(i >= R){
                pArr[i] = 1;
            }

            //情况二  下面的1、2、3种小情况都涵盖了
            if(i < R){
                pArr[i] = Math.min(pArr[2 * C - i], R - i);  //i位置以pArr[i]为半径的区域不需要再验证了
            }
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) { //往外扩 不能超过右边界 和 左边界
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) //往外看能不能扩
                    pArr[i]++;
                else {
                    break;
                }
            }

            if (i + pArr[i] > R) { //更新 R 和 C
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]); //更新max  最大半径
        }
        return max - 1;  //由于添加#处理了字符串  所以最后只需要获得的最大半径减1即可
    }


}
