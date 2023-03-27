package 基础班.第八节课;

/**
 * Author:松鼠
 * Date:2021/7/22 9:17
 */
public class Code05_ConvertToLetterString {
    public static void main(String[] args) {

    }

    public static int number(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] chars = str.toCharArray();
        return process(chars,0);
    }

    private static int process(char[] chars,int n) {
        if(n == chars.length)
            return 1;
        if(chars[n] == '0')
            return 0; //说明这条路断了  不可能有这种分支
        if(chars[n] == '1'){
            int res = process(chars,n+1);
            if(n+1 < chars.length)
                res += process(chars,n+2);
            return res;
        }
        if(chars[n] == '2'){
            int res = process(chars,n+1);
            if(n+1 < chars.length && chars[n+1]>= '0' && chars[n+1] <= '6') {
                res += process(chars, n + 2);
            }
            return res;
        }
        return process(chars,n+1);
    }
}
