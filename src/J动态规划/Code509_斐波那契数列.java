package J动态规划;

/**
 * @author 松鼠
 * @data 2022/1/11 14:13
 */
public class Code509_斐波那契数列 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
