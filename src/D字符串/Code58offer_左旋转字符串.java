package D字符串;

/**
 * @author 松鼠
 * @data 2021/12/22 20:08
 */
@SuppressWarnings("all")
public class Code58offer_左旋转字符串 {
    public static void main(String[] args) {

    }

    public static String reverseLeftWords(String s, int n) {
        int fast = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (fast < n){
            fast++;
        }
        stringBuffer.append(s.substring(fast,s.length()));
        stringBuffer.append(s.substring(0,fast));
        return stringBuffer.toString();


    }
}
