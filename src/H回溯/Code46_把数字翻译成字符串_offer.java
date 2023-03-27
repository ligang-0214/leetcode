package H回溯;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25
 * 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 这个题跟之前左神讲的有点点出入 但是不影响整个执行判断的逻辑
 *
 * Author:松鼠
 * Date:2021/7/22 14:28
 */
public class Code46_把数字翻译成字符串_offer {
    public static void main(String[] args) {
        int num = 056;
        System.out.println(translateNum(num));
    }

    public static int translateNum(int num) {
        return process(String.valueOf(num).toCharArray(),0);
    }

    private static int process(char[] chars,int n) {
        if(n == chars.length)
            return 1;
        if(chars[n] == '0'){
            return process(chars,n+1);
        }
        if(chars[n] == '1'){
            int res = process(chars,n+1);
            if(n+1 < chars.length)
                res += process(chars,n+2);
            return res;
        }
        if(chars[n] == '2'){
            int res = process(chars,n+1);
            if(n+1 < chars.length && chars[n+1]>= '0' && chars[n+1] <= '5') {
                res += process(chars, n + 2);
            }
            return res;
        }
        return process(chars,n+1);
    }
}
