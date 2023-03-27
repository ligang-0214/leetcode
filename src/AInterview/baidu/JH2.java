package AInterview.baidu;

import java.util.Scanner;

/**
 * @author 松鼠
 * @data 2022/3/29 19:51
 */
public class JH2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(longestPalindrome2(sc.nextLine()));
    }

    public static int longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2; //这里的 start 和 end 需要思考一下
                end = i + len / 2;
            }
        }
        return end - start + 1;
    }

    public static int expandAroundCenter(String s, int left, int right) {
        int flag0 = 0;
        int flag1 = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (s.charAt(left) == '0' || s.charAt(right) == '0')
                flag0++;
            if (s.charAt(left) == '1' || s.charAt(right) == '1')
                flag1++;
            --left;
            ++right;
        }
        if (flag0 >= 1 && flag1 >= 1) {
            return right - left - 1;
        } else {
            return 0;
        }
    }
}
