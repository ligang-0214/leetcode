package AA秋招.途虎养车;

/**
 * @author 松鼠
 * @data 2022/9/7 19:31
 */
public class demo1 {
    public static void main(String[] args) {

    }

    public int timeRequiredToBuyCounpons(int[] coupons, int m) {
        // write code here
        int len = coupons.length;
        int flag = 0;
        int res = 0;
        while (coupons[m] != 0) {
            if (flag == len) {
                flag = 0;
            }
            if (0 == coupons[flag]) {
                flag++;
            } else {
                coupons[flag++]--;
                res++;
            }
        }
        return res * 10;
    }
}
