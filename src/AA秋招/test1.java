package AA秋招;


import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 松鼠
 * @data 2022/9/5 14:09
 */
public class test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Map<Double, Double> res = new TreeMap<>();
        double p = 1030;
        double A = 0.0457;
        double C = 0.427;
        int m1 = 30;
        int m2 = 40;
        double Vm1 = 1.5;
        double Vm2 = 3.0;
        double Y = 5;
        int T = 0;
        while (Y < 200) {
            for (int t = 0; t <= 30; t += 1) {
                if (Y > 200) {
                    break;
                }
                double k1 = p * A * C / (2 * m1);
                double temp = Y + Math.log(Math.cosh(k1 * Vm1 * (t / 10.0))) / k1;
                res.put(T + (t / 10.0), temp);
                if (t / 10 == 3.0) {
                    Y = temp;
                }

            }

            T += 3;
            for (int t = 0; t <= 30; t += 1) {
                if (Y > 200) {
                    break;
                }
                double k2 = p * A * C / (2 * m2);
                double temp = Y + Math.log(Math.cosh(k2 * Vm2 * (t / 10.0))) / k2;
                res.put(T + (t / 10.0), temp);
                if (t / 10 == 3.0) {
                    Y = temp;
                }
            }
            T += 3;
        }
        // y3的公式

        for (Double aDouble : res.keySet()) {
            System.out.println("时间：" + String.format("%.1f", aDouble) + "  Y的值：" + res.get(aDouble));
        }


    }
}
