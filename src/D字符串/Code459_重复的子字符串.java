package D字符串;

/**
 * @author 松鼠
 * @data 2021/12/22 21:41
 */
public class Code459_重复的子字符串 {
    public static void main(String[] args) {
        String s = "abac";
        System.out.println(repeatedSubstringPattern(s));
    }


    public static boolean repeatedSubstringPattern(String s) {
        if(s.equals(""))
            return false;
        s += " "; //这里最后又添加了一个字符   就是为了可以获取s的最大前后缀长度
        int[] next = getNextArray(s.toCharArray());
        int length = s.length() - 1; //这里获取s原本的真实长度
        if(next[length] >0  && (length)%(length - next[length]) == 0){ //最重要的是这句判定  要理解它的意思
            return true;
        }
        return false;

    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1; //定死的
        next[1] = 0; //定死的
        int i = 2;
        int flag = 0; //拿哪个位置的字符和 i-1 的字符进行比较  最开始肯定是0位置
        while (i < next.length) {
            if (ms[i - 1] == ms[flag]) { //看i位置的前一位是否与 flag位置相等  i和flag都变化
                next[i++] = ++flag;
            } else if (flag > 0) { // 说明flag还没有跳到开头  还可以往前跳  flag变化
                flag = next[flag];
            } else { // flag跳到开头了 那i位置只能为0  i变化
                next[i++] = 0;
            }
        }
        return next;
    }
}
