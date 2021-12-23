package D字符串;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * @author 松鼠
 * @data 2021/12/22 18:55
 */
@SuppressWarnings("all")
public class Code344_反转字符串 {
    public static void main(String[] args) {

    }


    /**
     * 如果出了这题  就说明面试凉了。。  面试官不想浪费时间了
     * @param s
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right){
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            left++;
            right--;
        }
    }
}
