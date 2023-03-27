package Acodetop;

import java.text.DecimalFormat;

/**
 * @author 松鼠
 * @data 2022/2/25 9:17
 */
public class Code69_X的平方根_easy {

    // 需要控制小数点后几位的解法
    public static void main(String[] args) {
        int x = 8;
        if (x == 0) {
            return;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-3) {
                break;
            }
            x0 = xi;
        }
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.println(df.format(x0));
        System.out.println(((int) x0));
//        return (int) x0;
    }

    // 正常题目要求的二分解法
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }
        int left = 1;
        int right = x / 2;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(mid > x / mid){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return left;

    }

}
