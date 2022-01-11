package J动态规划;

/**
 * @author 松鼠
 * @data 2022/1/11 14:31
 */
public class Code70_爬楼梯 {
    //和斐波那契数列一样的
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }
}
