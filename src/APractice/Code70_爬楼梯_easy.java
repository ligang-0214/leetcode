package APractice;

/**
 * @author 松鼠
 * @data 2022/7/30 17:11
 */
public class Code70_爬楼梯_easy {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;

        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

}
